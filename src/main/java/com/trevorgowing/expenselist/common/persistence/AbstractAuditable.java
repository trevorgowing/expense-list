package com.trevorgowing.expenselist.common.persistence;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditable<U, PK extends Serializable> extends AbstractPersistable<PK>
    implements Auditable<U, PK> {

  private static final long serialVersionUID = 6786219322987115149L;

  @JoinColumn(name = "app_created_by_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private U createdBy;

  @Basic(optional = false)
  @Column(nullable = false, name = "app_created_date")
  @CreatedDate
  private Instant createdDate;

  @JoinColumn(name = "app_last_modified_by_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private U lastModifiedBy;

  @Column(name = "app_last_modified_date")
  @LastModifiedDate
  private Instant lastModifiedDate;

  protected AbstractAuditable(PK id) {
    super(id);
  }

  @Override
  public U getCreatedBy() {
    return createdBy;
  }

  @Override
  public void setCreatedBy(U createdBy) {
    this.createdBy = createdBy;
  }

  @Override
  public Instant getCreatedDate() {
    return createdDate;
  }

  @Override
  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public U getLastModifiedBy() {
    return lastModifiedBy;
  }

  @Override
  public void setLastModifiedBy(U lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  @Override
  public Instant getLastModifiedDate() {
    return lastModifiedDate;
  }

  @Override
  public void setLastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
}
