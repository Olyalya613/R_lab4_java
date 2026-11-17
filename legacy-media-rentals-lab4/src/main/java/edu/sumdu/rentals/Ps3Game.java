package edu.sumdu.rentals;

public class Ps3Game implements VideoGame {
    private static final double CONSOLE_RENTAL_COST = 29.99;
    private static final int NUM_DAYS_BASE_PRICE = 4;
    private static final double BASE_PRICE = 4;
    private static final double EXTRA_PRICE = 1.25;
    private static final int FREQUENT_RENTER_POINTS = 2;
    private final String gameName;

    public Ps3Game(String name) {
        gameName = name;
    }

    @Override
    public double getCharge(int daysRented, boolean consoleRented) {
        double result = BASE_PRICE;
        if (daysRented > NUM_DAYS_BASE_PRICE) {
            result += (daysRented - NUM_DAYS_BASE_PRICE) * EXTRA_PRICE;
        }
        if (consoleRented) {
            result += CONSOLE_RENTAL_COST + daysRented;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented, boolean consoleRented) {

        if (consoleRented && daysRented > NUM_DAYS_BASE_PRICE) {
            return FREQUENT_RENTER_POINTS + daysRented - NUM_DAYS_BASE_PRICE;
        }
        return FREQUENT_RENTER_POINTS;
    }

    @Override
    public String toString() {
        return gameName;
    }
}
