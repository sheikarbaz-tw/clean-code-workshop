package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement().display(this);
    }

    private int totalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + name + "</b></h1><br>");
        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle()).append(" ").append(rental.amount()).append("<br>");
        }
        result.append("Amount owed is <b>").append(totalAmount()).append("</b><br>");
        result.append("You earned <b>").append(totalFrequentRenterPoints()).append("</b> frequent renter points<br>");
        return result.toString();
    }

    private class TextStatement {
        public String display(Customer customer) {
            String result = "Rental Record for " + customer.getName() + "\n";
            double totalAmount = customer.totalAmount();
            int frequentRenterPoints = customer.totalFrequentRenterPoints();

            for (Rental rental : customer.rentals) {
                //show figures for this rental
                result += "\t" + rental.getMovie().getTitle() + "\t" +
                        String.valueOf(rental.amount()) + "\n";
            }
            result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
            result += "You earned " + String.valueOf(frequentRenterPoints)
                    + " frequent renter points";
            return result;
        }
    }
}

