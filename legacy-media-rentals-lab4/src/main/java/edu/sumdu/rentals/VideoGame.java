package edu.sumdu.rentals;

/** A common behavior contract for all supported video games. */
public interface VideoGame {
    double getCharge(int daysRented, boolean consoleRented);
    int getFrequentRenterPoints(int daysRented, boolean consoleRented);
}
