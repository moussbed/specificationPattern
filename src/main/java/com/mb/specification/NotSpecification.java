package com.mb.specification;

public class NotSpecification<T> extends AbstractCompositeSpecification<T> {

   protected Specification<T> specification;

   public NotSpecification(Specification<T> specification){
       this.specification=specification;

   }
    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !specification.isSatisfiedBy(candidate);
    }
}
