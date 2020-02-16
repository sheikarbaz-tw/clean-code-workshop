package com.movierental;

import java.util.List;

class TextStatement {
    public String display(Rentals rentals, String name) {
        String result = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
        result += "You earned " + String.valueOf(rentals.totalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }
}
