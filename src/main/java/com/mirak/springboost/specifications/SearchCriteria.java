package com.mirak.springboost.specifications;

import com.mirak.springboost.specifications.enums.Operation;
import com.mirak.springboost.specifications.enums.Operator;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public class SearchCriteria {

	private Operation operation;
	private Operator operator;

	private Comparable<? extends Object> firstOperand;
	private Comparable<? extends Object>  secondOperand;

	public SearchCriteria() {
	}
	
	/**
	 * @param operation
	 * @param operator
	 * @param firstOperand
	 * @param secondOperand
	 */
	public SearchCriteria(Operation operation, Operator operator, Comparable<? extends Object>  firstOperand, Comparable<? extends Object>  secondOperand) {
		this.operation = operation;
		this.operator = operator;
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}

	/**
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * @return the first Operand
	 */
	public Comparable<? extends Object> getFirstOperand() {
		return firstOperand;
	}

	/**
	 * @param firstOperand the first Operand to set
	 */
	public void setFirstOperand(Comparable<? extends Object> firstOperand) {
		this.firstOperand = firstOperand;
	}

	/**
	 * @return the second Operand
	 */
	public Comparable<? extends Object> getSecondOperand() {
		return secondOperand;
	}

	/**
	 * @param secondOperand the second Operand to set
	 */
	public void setSecondOperand(Comparable<? extends Object> secondOperand) {
		this.secondOperand = secondOperand;
	}

}
