package edu.sumdu.rentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMixedTest {
    @Test
    void mixedInvoicePreservesOrderTotalsAndBonusAccumulation() {
        Customer customer = new Customer("Ana");
        customer.addMovieRental(new MovieRental(
                new Movie("Regular", Movie.REGULAR), 3));
        customer.addMovieRental(new MovieRental(
                new Movie("Premiere", Movie.NEW_RELEASE), 2));
        customer.addVideoGameRental(new VideoGameRental(
                new Ps3Game("Little Big Planet"), 5, false));

         String expected = "Rental Record for Ana\n"
                 + "\tRegular\t3.5\n"
                 + "\tPremiere\t6.0\n"
                 + "\tLittle Big Planet\t5.25\n"
                 + "Amount owed is 14.75\n"
                 + "You earned 5 frequent renter points";
         assertEquals(expected, customer.statement());
     }
}
