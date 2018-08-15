package org.jbpm.spring.model;

import java.util.Collection;

public class CaseListing
{
  private Collection<Case> cases;

  public CaseListing()
  {
  }

  public CaseListing(Collection<Case> cases)
  {
    this.cases = cases;
  }

  public Collection<Case> getCases() {
    return this.cases;
  }
}