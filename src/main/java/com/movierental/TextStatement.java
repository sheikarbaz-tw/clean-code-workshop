package com.movierental;

import java.util.List;

class TextStatement {
    public String display(List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints, String name) {
        String result = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(totalFrequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
