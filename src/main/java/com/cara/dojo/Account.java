package com.cara.dojo;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final String HEADER = "DATE | AMOUNT | BALANCE";

    private final Printer printer;
    private final List<Operation> operations;
    private final Clock clock;

    private int balance = 0;

    public Account(Printer printer, Clock clock) {
        this.printer = printer;
        this.clock = clock;
        this.operations = new ArrayList<>();
    }

    public void printStatement() {
        printer.printLine(HEADER);

        operations.stream()
                .sorted(Operation.compareByDate().reversed())
                .forEach(operation -> operation.printTo(printer));
    }

    public void deposit(int amount) {
        addOperation(amount);
    }

    public void withdraw(int amount) {
        addOperation(-1 * amount);
    }

    private void addOperation(int amount) {
        balance += amount;
        operations.add(new Operation(amount, clock.now(), balance));
    }
}
