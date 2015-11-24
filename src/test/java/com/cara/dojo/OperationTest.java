package com.cara.dojo;

import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OperationTest {

    @Test
    public void should_print_to_printer() {
        // given
        Printer printer = mock(Printer.class);
        Operation operation = new Operation(100, LocalDate.of(1988, 12, 21), 100);

        // when
        operation.printTo(printer);

        // then
        verify(printer).printLine("21/12/1988 | 100.00 | 100.00");
    }

}