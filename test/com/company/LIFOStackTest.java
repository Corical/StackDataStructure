package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIFOStackTest {

    @Test
    void pushOneValueTest() {
        LIFOStack LIFOStack = new LIFOStack();
        LIFOStack.push("String");
        assertEquals(1, LIFOStack.count());
    }

    @Test
    void pushMultipleValuesTest() {
        LIFOStack LIFOStack = new LIFOStack();
        int amountToPush = 15;

        for (int i = 0; i < amountToPush; i++) {
            LIFOStack.push(i);
        }
        assertEquals(amountToPush, LIFOStack.count());
    }

    @Test
    void popOneValueTest() {
        LIFOStack LIFOStack = new LIFOStack();
        LIFOStack.push("String");
        LIFOStack.pop();
        assertEquals(0, LIFOStack.count());
    }

    @Test
    void pushMultiplePopMultipleButNotAllTest() {
        int amountToPush = 50000;
        int amountToPop = 10000;
        LIFOStack LIFOStack = new LIFOStack();
        pushPopMultiple(LIFOStack, amountToPush, amountToPop);
        int expectedValue = amountToPush >= amountToPop ? amountToPush - amountToPop : 0;
        assertEquals(expectedValue, LIFOStack.count());
    }

    @Test
    void pushMultiplePopMultipleMoreThanExistsTest() {
        int amountToPush = 5;
        int amountToPop = 6;
        LIFOStack LIFOStack = new LIFOStack();
        pushPopMultiple(LIFOStack, amountToPush, amountToPop);
        assertEquals(0, LIFOStack.count());
    }

    void pushPopMultiple(LIFOStack LIFOStack, int amountToPush, int amountToPop) {
        for (int i = 0; i < amountToPush; i++) {
            LIFOStack.push(i);
        }

        for (int i = 0; i < amountToPop; i++) {
            LIFOStack.pop();
        }
    }

    @Test
    void pushMultipleCountTest() {
        int amountToPush = 13;
        int amountToPop = 0;
        LIFOStack LIFOStack = new LIFOStack();
        pushPopMultiple(LIFOStack, amountToPush, amountToPop);
        int expectedValue = amountToPush >= amountToPop ? amountToPush - amountToPop : 0;
        assertEquals(expectedValue, LIFOStack.count());
    }

    @Test
    void emptyTest() {
        LIFOStack LIFOStack = new LIFOStack();
        LIFOStack.push("String");
        assertEquals(false, LIFOStack.empty());
    }

    @Test
    void multipleTypeTest() {
        LIFOStack LIFOStack = new LIFOStack<>();
        LIFOStack.push("asd");
        LIFOStack.push(2);
        LIFOStack.push('c');
        LIFOStack.push(new LIFOStack<String>());
        LIFOStack.pop();
        LIFOStack.pop();
        assertEquals(2, LIFOStack.count());
    }

    @Test
    void poppingFromEmptyStackTest()
    {
        LIFOStack LIFOStack = new LIFOStack();
        Object poppedItem = LIFOStack.pop();
        assertNull(poppedItem);
    }

    @Test
    void pushingNullTest()
    {
        LIFOStack LIFOStack = new LIFOStack();
        LIFOStack.push(null);
        assertEquals(0, LIFOStack.count());
    }

    @Test
    void pushingTenMillion()
    {
        int maxAmountOfItems = 10000000;
        LIFOStack LIFOStack = new LIFOStack();
        for (int x=0;x<maxAmountOfItems;x++)
        {
            LIFOStack.push(x);
        }
        assertEquals(maxAmountOfItems, LIFOStack.count());
    }
}