package edu.sumdu.rentals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingBoundaryTest {
    @ParameterizedTest(name = "REGULAR: days={0}")
    @CsvSource({"2, 2.0", "3, 3.5"})
    void regularAtAndAfterBoundary(int days, String expectedCost) {
        Customer customer = new Customer("Ana");
        customer.addMovieRental(new MovieRental(
                new Movie("Film", Movie.REGULAR), days));
        assertEquals(expectedInvoice(expectedCost, 1), customer.statement());
    }

    @ParameterizedTest(name = "CHILDRENS: days={0}")
    @CsvSource({"3, 1.5", "4, 2.75"})
    void childrenAtAndAfterBoundary(int days, String expectedCost) {
        Customer customer = new Customer("Ana");
        customer.addMovieRental(new MovieRental(
                new Movie("Film", Movie.CHILDRENS), days));
        assertEquals(expectedInvoice(expectedCost, 1), customer.statement());
    }

    @ParameterizedTest(name = "NEW_RELEASE: days={0}")
    @CsvSource({"1, 3.0, 1", "2, 6.0, 2"})
    void newReleasePointsBoundary(int days, String expectedCost, int points) {
        Customer customer = new Customer("Ana");
        customer.addMovieRental(new MovieRental(
                new Movie("Film", Movie.NEW_RELEASE), days));
        assertEquals(expectedInvoice(expectedCost, points), customer.statement());
    }

    private String expectedInvoice(String cost, int points) {
        return "Rental Record for Ana\n"
                + "\tFilm\t" + cost + "\n"
                + "Amount owed is " + cost + "\n"
                + "You earned " + points + " frequent renter points";
    }
}
