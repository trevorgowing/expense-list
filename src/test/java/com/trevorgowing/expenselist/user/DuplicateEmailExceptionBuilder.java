package com.trevorgowing.expenselist.user;

import com.trevorgowing.expenselist.common.builders.DomainObjectBuilder;

import static com.trevorgowing.expenselist.user.DuplicateEmailException.causedDuplicateEmailException;

public final class DuplicateEmailExceptionBuilder implements DomainObjectBuilder<DuplicateEmailException> {

  private String email;
  private Throwable cause = new RuntimeException("Root cause exception");

  public static DuplicateEmailExceptionBuilder aDuplicateEmailException() {
    return new DuplicateEmailExceptionBuilder();
  }

  @Override
  public DuplicateEmailException build() {
    return causedDuplicateEmailException(email, cause);
  }

  public DuplicateEmailExceptionBuilder withEmail(String email) {
    this.email = email;
    return this;
  }
}
