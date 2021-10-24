package com.mb.specification.model;

import java.util.List;

public class Slot {

    private List<Booking> activeBookings;

    public List<Booking> getActiveBookings() {
        return activeBookings;
    }

    public void setActiveBookings(List<Booking> activeBookings) {
        this.activeBookings = activeBookings;
    }
}
