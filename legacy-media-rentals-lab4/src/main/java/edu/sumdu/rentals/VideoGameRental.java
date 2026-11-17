package edu.sumdu.rentals;

public class VideoGameRental {
    private final VideoGame videoGame;
    private final int daysRented;
    private final boolean consoleRented;

    public VideoGameRental(VideoGame videoGame, int daysRented, boolean consoleRented) {
        if (videoGame == null) {
            throw new IllegalArgumentException("Unsupported game type");
        }
        this.videoGame = videoGame;
        this.daysRented = daysRented;
        this.consoleRented = consoleRented;
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return videoGame.getCharge(daysRented, consoleRented);
    }

    public int getFrequentRenterPoints() {
        return videoGame.getFrequentRenterPoints(daysRented, consoleRented);
    }
}
