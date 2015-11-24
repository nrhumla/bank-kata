package com.cara.dojo;

import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountTest {

    @Test
    public void should_print_header_when_no_transaction() {
        // given
        Printer printer = mock(Printer.class);
        Account account = new Account(printer, null);

        // when
        account.printStatement();

        // then
        verify(printer).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void should_print_incremented_balance_when_deposit() {
        // given
        Printer printer = mock(Printer.class);
        Clock clock = mock(Clock.class);
        Account account = new Account(printer, clock);
        when(clock.now()).thenReturn(LocalDate.of(1988, 12, 21));

        account.deposit(100);

        // when
        account.printStatement();

        // then
        verify(printer).printLine("DATE | AMOUNT | BALANCE");
        verify(printer).printLine("21/12/1988 | 100.00 | 100.00");
    }

    @Test
    public void should_print_decremented_balance_when_withdraw() {
        // given
        Printer printer = mock(Printer.class);
        Clock clock = mock(Clock.class);
        Account account = new Account(printer, clock);
        when(clock.now()).thenReturn(LocalDate.of(1988, 12, 21));

        account.withdraw(100);

        // when
        account.printStatement();

        // then
        verify(printer).printLine("DATE | AMOUNT | BALANCE");
        verify(printer).printLine("21/12/1988 | -100.00 | -100.00");
    }

}