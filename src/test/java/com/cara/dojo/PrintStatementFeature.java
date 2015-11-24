package com.cara.dojo;

import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PrintStatementFeature {

    @Test
    public void should_print_statement_containing_transactions_in_reverse_order() {
        // given
        Printer printer = mock(Printer.class);
        Clock clock = mock(Clock.class);
        Account account = new Account(printer, clock);

        when(clock.now()).thenReturn(LocalDate.of(2014, 4, 1));
        account.deposit(1000);

        when(clock.now()).thenReturn(LocalDate.of(2014, 4, 2));
        account.withdraw(100);

        when(clock.now()).thenReturn(LocalDate.of(2014, 4, 10));
        account.deposit(500);

        // when
        account.printStatement();

        // then
        verify(printer).printLine("DATE | AMOUNT | BALANCE");
        verify(printer).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(printer).printLine("02/04/2014 | -100.00 | 900.00");
        verify(printer).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
