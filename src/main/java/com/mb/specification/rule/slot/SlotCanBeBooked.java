package com.mb.specification.rule.slot;

import com.mb.specification.LeafSpecification;
import com.mb.specification.model.Slot;

public class SlotCanBeBooked extends LeafSpecification<Slot> {

    private int reservationLimit ;

    public SlotCanBeBooked() {
    }

    public SlotCanBeBooked(int reservationLimit) {
        this.reservationLimit = reservationLimit;
    }

    @Override
    public boolean isSatisfiedBy(Slot candidate) {
        return candidate.getActiveBookings().size() <= reservationLimit;
    }
}
