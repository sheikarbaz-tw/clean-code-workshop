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

    @Test
    public void shouldReturnHtmlStatement() {
        Customer customer = new Customer("Vivek");
        Rental rental = warMovieFOrRental();
        customer.addRental(rental);
        String expectedResult = "<h1>Rental Record for <b>Vivek</b></h1><br>" +
                "War 15.0<br>" +
                "Amount owed is <b>15.0</b><br>" +
                "You earned <b>2</b> frequent renter points<br>";

        assertEquals(expectedResult, customer.htmlStatement());
    }


    private Rental warMovieFOrRental() {
        Movie warMovie = new Movie("War", Movie.NEW_RELEASE);
        return new Rental(warMovie, 5);
    }

}