package edu.sumdu.rentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieRentalTest {
    @Test
    void storesRentedMovieAndNumberOfDays() {
        Movie movie = new Movie("Mulan", Movie.CHILDRENS);
        MovieRental rental = new MovieRental(movie, 4);
        assertEquals(movie, rental.getMovie());
        assertEquals(4, rental.getDaysRented());
    }
}
