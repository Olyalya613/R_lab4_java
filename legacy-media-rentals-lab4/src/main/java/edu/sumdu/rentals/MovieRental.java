package edu.sumdu.rentals;

public class MovieRental {
    private static final int REGULAR_BASE_DAYS = 2;
    private static final double REGULAR_BASE_CHARGE = 2.0;
    private static final double REGULAR_EXTRA_DAY_CHARGE = 1.5;
    private static final int CHILDRENS_BASE_DAYS = 3;
    private static final double CHILDRENS_BASE_CHARGE = 1.5;
    private static final double CHILDRENS_EXTRA_DAY_CHARGE = 1.25;
    private static final int NEW_RELEASE_DAILY_CHARGE = 3;

    private final Movie movie;
    private final int daysRented;

    public MovieRental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        double charge = 0;
        // Determine the price of rental rental.
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                charge += REGULAR_BASE_CHARGE;
                if (daysRented > REGULAR_BASE_DAYS) {
                    charge += (daysRented - REGULAR_BASE_DAYS) * REGULAR_EXTRA_DAY_CHARGE;
                }
                break;
            case Movie.NEW_RELEASE:
                charge += daysRented * NEW_RELEASE_DAILY_CHARGE;
                break;
            case Movie.CHILDRENS:
                charge += CHILDRENS_BASE_CHARGE;
                if (daysRented > CHILDRENS_BASE_DAYS) {
                    charge += (daysRented - CHILDRENS_BASE_DAYS) * CHILDRENS_EXTRA_DAY_CHARGE;
                }
                break;
            default:
                // Deliberate legacy behavior: unknown price code silently costs zero.
                break;
        }
        return charge;
    }

    public int getFrequentRenterPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1 ? 2 : 1;
    }
}
