package com.mb.specification.rule.user;

import com.mb.specification.LeafSpecification;
import com.mb.specification.model.User;

public class HasAtLeastOneBooking extends LeafSpecification<User> {

    @Override
    public boolean isSatisfiedBy(User candidate) {
        return candidate.getActiveBookings().size()>=1;
    }
}
