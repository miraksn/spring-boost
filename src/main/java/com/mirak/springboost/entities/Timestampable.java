package com.mirak.springboost.entities;


import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mirak.springboost.serives.annotations.searchable.Searchable;
import com.mirak.springboost.serives.annotations.searchable.enums.Type;

/**
 * 
 * @author karim SNOUSSI
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Timestampable implements Serializable {

	protected static final long serialVersionUID = 0000000000000000001L;

    @Searchable(type = Type.DATE, target = "createdAt")
	@Column(nullable = true, columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSZ", timezone = "UTC")
    protected OffsetDateTime createdAt;

    @Searchable(type = Type.DATE, target = "updatedAt")
    @Column(nullable = true, columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSZ", timezone = "UTC")
    protected OffsetDateTime updatedAt;

    @Searchable(type = Type.STRING, target = "uuid")
    @Column(unique = true, nullable = false)
    private String uuid;

    /**
     * On create.
     */
    @PrePersist
    protected void onCreate() {
        this.uuid =  UUID.randomUUID().toString();
        this.updatedAt = this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);

    }

    /**
     * On update.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Timestampable{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestampable that = (Timestampable) o;
        return Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(uuid, that.uuid);
    }

}
