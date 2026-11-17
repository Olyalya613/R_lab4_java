package edu.sumdu.rentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoGameRentalTest {

      @Test
      void ps3FiveDaysWithoutConsoleCostsFivePointTwentyFive() {
          VideoGameRental rental = new VideoGameRental(new Ps3Game("Little Big Planet"), 5, false);
          assertEquals(5.25, rental.getCharge(), 1e-9);
          assertEquals(2, rental.getFrequentRenterPoints());
      }

      @Test
      void wiiFiveDaysWithConsoleAddsFeeAndBonus() {
          VideoGameRental rental = new VideoGameRental(new WiiGame("Family game"), 5, true);
          assertEquals(40.24, rental.getCharge(), 1e-9);
          assertEquals(6, rental.getFrequentRenterPoints());
      }
}
