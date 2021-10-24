package com.mb.specification;

import com.mb.specification.model.Booking;
import com.mb.specification.model.Slot;
import com.mb.specification.model.User;
import com.mb.specification.rule.user.HasAtLeastOneBooking;
import com.mb.specification.rule.user.IsUserActive;
import com.mb.specification.rule.slot.SlotCanBeBooked;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final IsUserActive isUserActive = new IsUserActive();
        final HasAtLeastOneBooking hasAtLeastOneBooking = new HasAtLeastOneBooking();
        final SlotCanBeBooked slotCanBeBooked = new SlotCanBeBooked(10);

        final User user = new User();
        user.setActive(true);
        user.setActiveBookings(List.of(new Booking()));

        Slot slot = new Slot();
        slot.setActiveBookings(List.of(new Booking(),new Booking()));

        // Rule 1 : User is active and has at least one booking
        Specification<User> userCanBook1 = isUserActive.and(hasAtLeastOneBooking);
        System.out.println("User is active and has at least one booking => " + userCanBook1.isSatisfiedBy(user));

        // Rule 2 : User is active and not has at least one booking
        Specification<User> userCanBook2 = isUserActive.and(hasAtLeastOneBooking.not());
        System.out.println("User is active and not has at least one booking => " + userCanBook2.isSatisfiedBy(user));

        //Rule 3 : Slot has not reached limit
        final boolean slotCanBeBookedCheck = slotCanBeBooked.isSatisfiedBy(slot);
        System.out.println("Slot has not reached limit => " + slotCanBeBookedCheck);
        final ArrayList<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bookings.add(new Booking());
        }
        slot.setActiveBookings(bookings);

        // Rule 4 : Slot has reached limit
        final boolean slotCanBeBookedCheck2 = slotCanBeBooked.not().isSatisfiedBy(slot);
        System.out.println("Slot has reached limit => " + slotCanBeBookedCheck2);


        //  Rule 5 : User is active and not has at least one booking and Slot has not reached limit
        slot.setActiveBookings(List.of(new Booking()));
        user.setActiveBookings(new ArrayList<>());
        final boolean satisfied = isUserActive.and(hasAtLeastOneBooking.not()).isSatisfiedBy(user) && slotCanBeBooked.isSatisfiedBy(slot);
        System.out.println("User is active and not has at least one booking and Slot has not reached limit => " + satisfied);


    }
}
