package com.mb.specification;

public class AndSpecification<T> extends AbstractCompositeSpecification<T> {

    public AndSpecification(Specification<T>... specifications) {
        super(specifications);
    }

    @Override
    public boolean isSatisfiedBy(final T candidate) {
        boolean result = true;
        for (Specification<T> specification : this.specifications) {
            result = result && specification.isSatisfiedBy(candidate);
            if(!result) break;
        }
        return result;

    }
}
