package edu.sumdu.rentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    @Test
    void emptyCustomerHasZeroBalanceAndPoints() {
        Customer customer = new Customer("Ana");
        assertEquals("Rental Record for Ana\n"
                        + "Amount owed is 0.0\n"
                        + "You earned 0 frequent renter points",
                customer.statement());
    }

    @Test
    void newReleaseTwoDaysEarnsTwoPoints() {
        Customer customer = new Customer("Ana");
        customer.addMovieRental(new MovieRental(new Movie("New film", Movie.NEW_RELEASE), 2));
        assertEquals("Rental Record for Ana\n"
                        + "\tNew film\t6.0\n"
                        + "Amount owed is 6.0\n"
                        + "You earned 2 frequent renter points",
                customer.statement());
    }
}
