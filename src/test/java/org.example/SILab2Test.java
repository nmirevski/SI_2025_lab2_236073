package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test
    public void testAllItemsNull() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678")
        );
        assertEquals("allItems list can't be null!", ex.getMessage());
    }

    @Test
    public void testItemNameNull() {
        List<Item> items = List.of(new Item(null, 1, 100, 0.0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "1234567812345678")
        );
        assertEquals("Invalid item!", ex.getMessage());
    }

    @Test
    public void testInvalidCardCharacter() {
        List<Item> items = List.of(new Item("Book", 1, 100, 0.0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "12345678abcd5678")
        );
        assertEquals("Invalid character in card number!", ex.getMessage());
    }

    @Test
    public void testInvalidCardLength() {
        List<Item> items = List.of(new Item("Book", 1, 100, 0.0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "12345678")
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }

    @Test
    public void testValidCase() {
        List<Item> items = Arrays.asList(
                new Item("Book", 5, 400, 0.2),      // > 300 + discount → penalty + discounted price
                new Item("Notebook", 3, 200, 0.0)   // regular price
        );

        double expected = 0;
        expected -= 30; // penalty for Book
        expected += 400 * (1 - 0.2) * 5; // Book with discount
        expected += 200 * 3; // Notebook

        double result = SILab2.checkCart(items, "1234567812345678");
        assertEquals(expected, result);
    }

    // TXX → price > 300
    @Test
    public void testTXX() {
        List<Item> items = List.of(new Item("Nino", 0, 310, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, null)
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }

    // FTX → discount > 0
    @Test
    public void testFTX() {
        List<Item> items = List.of(new Item("Nino", 1, 100, 0.1));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, null)
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }

    // FFF → all conditions false
    @Test
    public void testFFF() {
        List<Item> items = List.of(new Item("Nino", 1, 100, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, null)
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }

    // FFT → quantity > 10
    @Test
    public void testFFT() {
        List<Item> items = List.of(new Item("Nino", 11, 100, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, null)
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }
}
