package com.movierental;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

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
        return new TextStatement().display(this.rentals, this.getName());
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

    private int totalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
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

}

