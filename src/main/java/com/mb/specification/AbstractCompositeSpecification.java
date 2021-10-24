package com.mb.specification;

public abstract class AbstractCompositeSpecification<T>  implements Specification<T>{
    protected  Specification<T>[] specifications;

    public AbstractCompositeSpecification() {
    }

    @SafeVarargs
    public AbstractCompositeSpecification(Specification<T>... specifications) {
        this.specifications = specifications;
    }

    @Override
    public Specification<T> or(Specification<T> specification) {
        return new OrSpecification(this,specification);
    }

    @Override
    public Specification<T> and(Specification<T> specification) {
        return new AndSpecification(this,specification);
    }

    @Override
    public Specification<T> not() {
        return new NotSpecification<T>(this);
    }
}
