package com.mirak.springboost.specifications;

import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.Assert;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public abstract class DefaultSpecification<T> {

	private final static String CRITERIA_NULL = "CRITERIA OBJECT CAN NOT BE NULL";
	private final static String OPERATION_NULL = "OPERATION CAN NOT BE NULL";
	private final static String OPERATOR_NULL = "OPERATOR CAN NOT BE NULL";
	private final static String FIRST_OPERAND_NULL = "FIRST OPERAND CAN NOT BE NULL";
	private final static String SECOND_OPERAND_NULL = "SECOND OPERAND CAN NOT BE NULL";

	protected SearchCriteria criteria;

	protected DefaultSpecification() {
	}

	protected DefaultSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Assert.notNull(criteria, CRITERIA_NULL);
		Assert.notNull(criteria.getOperation(), OPERATION_NULL);
		Assert.notNull(criteria.getOperator(), OPERATOR_NULL);
		Assert.notNull(criteria.getFirstOperand(), FIRST_OPERAND_NULL);
		Assert.notNull(criteria.getSecondOperand(), SECOND_OPERAND_NULL);

		Predicate predicate = null;

		switch (criteria.getOperation()) {
		case COLUMN_TO_COLUMN:
			toPredicateColumnToColumn(root, query, builder, predicate);
			break;
		case COLUMN_TO_VALUE:
			toPredicateColumnToValue(root, query, builder, predicate);
			break;
		default:
			break;
		}
		return predicate;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void toPredicateColumnToValue(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder,
			Predicate predicate) {
		switch (criteria.getOperator()) {
		case AFTER:
			predicate = builder.greaterThan(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case EQUALS_OR_AFTER:
			predicate = builder.greaterThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case BEFORE:
			predicate = builder.lessThan(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case EQUALS_OR_BEFORE:
			predicate = builder.lessThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case EQUALS:
			predicate = builder.equal(getPath(root, (String) criteria.getFirstOperand()), criteria.getSecondOperand());
			break;
		case LIKE:
			predicate = builder.like(root.<String>get((String) criteria.getFirstOperand()),
					(String) criteria.getSecondOperand());
			break;
		case LESS_THAN:
			predicate = builder.lessThan(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case EQUALS_OR_LESS_THAN:
			predicate = builder.lessThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case MORE_THAN:
			predicate = builder.greaterThan(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case EQUALS_OR_MORE_THAN:
			predicate = builder.greaterThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					(Comparable) criteria.getSecondOperand());
			break;
		case CONTAINS:
			predicate = builder.isMember(criteria.getSecondOperand(),
					root.<Collection>get((String) criteria.getFirstOperand()));
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private void toPredicateColumnToColumn(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder,
			Predicate predicate) {
		switch (criteria.getOperator()) {
		case AFTER:
			predicate = builder.greaterThan(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case EQUALS_OR_AFTER:
			predicate = builder.greaterThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case BEFORE:
			predicate = builder.lessThan(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case EQUALS_OR_BEFORE:
			predicate = builder.lessThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case EQUALS:
			predicate = builder.equal(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case LIKE:
			predicate = builder.like(root.<String>get((String) criteria.getFirstOperand()),
					root.<String>get((String) criteria.getSecondOperand()));
			break;
		case LESS_THAN:
			predicate = builder.lessThan(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case EQUALS_OR_LESS_THAN:
			predicate = builder.lessThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case MORE_THAN:
			predicate = builder.greaterThan(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		case EQUALS_OR_MORE_THAN:
			predicate = builder.greaterThanOrEqualTo(getPath(root, (String) criteria.getFirstOperand()),
					getPath(root, (String) criteria.getSecondOperand()));
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("rawtypes")
	protected Path<Comparable> getPath(Root<T> root, String operand) {
		if (operand == null || operand.isEmpty()) {
			return null;
		} else if (operand.contains("#")) {
			String[] operands = operand.split("#");
			Path<Comparable> pathto = root.get(operands[0]);
			for (int i = 0; i < operands.length; i++) {
				if (operands[i] == null || operands[i].isEmpty()) {
					return null;
				}
				pathto = pathto.<Comparable>get(operands[i]);
			}
			return pathto;
		}
		return null;

	}

}
