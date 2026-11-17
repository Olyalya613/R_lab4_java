package edu.sumdu.rentals;

import java.util.Vector;

/** Legacy code kept intentionally imperfect for safe-refactoring practice. */

public class Customer {
    private String name;
    private final Vector<MovieRental> movieRentals = new Vector<>();
    private final Vector<VideoGameRental> gameRentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMovieRental(MovieRental rental) {
        movieRentals.addElement(rental);
    }

    public void addVideoGameRental(VideoGameRental rental) {
        gameRentals.addElement(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for ").append(name).append('\n');

        for (MovieRental rental : movieRentals) {
            double charge = rental.getCharge();

            frequentRenterPoints += rental.getFrequentRenterPoints();
            result.append('\t').append(rental.getMovie().getTitle()).append('\t').append(charge).append('\n');
            totalAmount += charge;
        }

        for (VideoGameRental rental : gameRentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
            double charge = rental.getCharge();
            result.append('\t').append(rental.getVideoGame()).append('\t').append(charge).append('\n');
            totalAmount += charge;
        }
        result.append("Amount owed is ").append(totalAmount).append('\n');
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }
}
