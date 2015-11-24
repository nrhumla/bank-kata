package com.cara.dojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.StringJoiner;

public class Operation {

    private static final String DATE_PATTERN = "dd/MM/yyyy";

    private final int amount;
    private final LocalDate date;
    private final int balance;

    public Operation(int amount, LocalDate date, int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public void printTo(Printer printer) {
        printer.printLine(
                new StringJoiner(" | ")
                        .add(date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)))
                        .add(amount + ".00")
                        .add(balance + ".00")
                        .toString()
        );
    }

    public static Comparator<Operation> compareByDate() {
        return (o1, o2) -> o1.date.compareTo(o2.date);
    }
}
