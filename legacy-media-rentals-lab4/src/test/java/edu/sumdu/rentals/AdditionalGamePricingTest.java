package edu.sumdu.rentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionalGamePricingTest {
    @Test
    void ps3ConsoleAtBoundary() {
        assertRental(new VideoGameRental(new Ps3Game("PS3"), 4, true), 37.99, 2);
    }

    @Test
    void ps3ConsolePastBoundary() {
        assertRental(new VideoGameRental(new Ps3Game("PS3"), 5, true), 40.24, 3);
    }

    @Test
    void xboxWithoutConsoleAtBoundary() {
        assertRental(new VideoGameRental(new Xbox360Game("Xbox"), 3, false), 3.5, 2);
    }

    @Test
    void xboxConsolePastBoundary() {
        assertRental(new VideoGameRental(new Xbox360Game("Xbox"), 4, true), 38.99, 3);
    }

    @Test
    void wiiWithoutConsoleAtBoundary() {
        assertRental(new VideoGameRental(new WiiGame("Wii"), 4, false), 3.0, 1);
    }

    @Test
    void invoiceKeepsMoviesFirstAndBothGamesInInsertionOrder() {
        Customer customer = new Customer("Ana");
        customer.addVideoGameRental(new VideoGameRental(new WiiGame("Wii"), 4, false));
        customer.addMovieRental(new MovieRental(new Movie("Film", Movie.REGULAR), 2));
        customer.addVideoGameRental(new VideoGameRental(new Xbox360Game("Xbox"), 3, false));

        assertEquals("Rental Record for Ana\n"
                + "\tFilm\t2.0\n"
                + "\tWii\t3.0\n"
                + "\tXbox\t3.5\n"
                + "Amount owed is 8.5\n"
                + "You earned 4 frequent renter points", customer.statement());
    }

    private void assertRental(VideoGameRental rental, double charge, int points) {
        assertEquals(charge, rental.getCharge(), 1e-9);
        assertEquals(points, rental.getFrequentRenterPoints());
    }
}
