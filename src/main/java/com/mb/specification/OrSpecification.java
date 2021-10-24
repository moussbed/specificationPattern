package com.mb.specification;

public class OrSpecification<T> extends AbstractCompositeSpecification<T> {

    public OrSpecification(Specification<T>... specifications) {
        super(specifications);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        boolean result =false;
        for (Specification<T> specification : this.specifications) {
              result = specification.isSatisfiedBy(candidate) || result;
              if(result) break;
        }
        return result;
    }
}
