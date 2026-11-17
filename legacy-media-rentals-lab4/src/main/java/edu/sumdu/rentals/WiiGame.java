package edu.sumdu.rentals;

public class WiiGame implements VideoGame {
    private static final double CONSOLE_RENTAL_COST = 29.99;
    private static final double CONSOLE_MODIFIER = 0.75;
    private static final int NUM_DAYS_BASE_PRICE = 4;
    private static final double BASE_PRICE = 3;
    private static final double EXTRA_PRICE = 1.50;
    private static final int FREQUENT_RENTER_POINTS = 1;
    private final String gameName;

    public WiiGame(String name) {
        gameName = name;
    }

    @Override
    public double getCharge(int daysRented, boolean consoleRented) {

        double result = BASE_PRICE;
        if (daysRented > NUM_DAYS_BASE_PRICE) {
            result += (daysRented - NUM_DAYS_BASE_PRICE) * EXTRA_PRICE;
        }
        if (consoleRented) {
            result += CONSOLE_MODIFIER;
            result += CONSOLE_RENTAL_COST + daysRented;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented, boolean consoleRented) {
        if (consoleRented) {
            return FREQUENT_RENTER_POINTS + daysRented;
        }
        return FREQUENT_RENTER_POINTS;
    }

    @Override
    public String toString() {
        return gameName;
    }
}
