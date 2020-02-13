package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void shouldReturnStatementForTheNewReleaseMovieRented() {
        Customer customer = new Customer("Vivek");
        Rental rental = warMovieFOrRental();
        customer.addRental(rental);
        String expectedResult = "Rental Record for Vivek\n" +
                "\tWar\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points";

        assertEquals(expectedResult, customer.statement());
    }

    private Rental warMovieFOrRental() {
        Movie warMovie = new Movie("War", Movie.NEW_RELEASE);
        return new Rental(warMovie, 5);
    }


}