package com.mb.specification.model;

import java.util.List;

public class User {

    private boolean active;

    private List<Booking> activeBookings;

    public User() {
    }

    public User(boolean active, List<Booking> activeBookings) {
        this.active = active;
        this.activeBookings = activeBookings;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Booking> getActiveBookings() {
        return activeBookings;
    }

    public void setActiveBookings(List<Booking> activeBookings) {
        this.activeBookings = activeBookings;
    }
}
