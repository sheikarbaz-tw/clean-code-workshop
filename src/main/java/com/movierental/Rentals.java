package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    double totalAmount() {
        return this.stream().mapToDouble(Rental::amount).sum();
    }

    int totalFrequentRenterPoints() {
        return this.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}
