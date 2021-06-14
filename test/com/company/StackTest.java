package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushOneValueTest() {
        Stack stack = new Stack();
        stack.push("String");
        assertEquals(1, stack.count());
    }

    @Test
    void pushMultipleValuesTest() {
        Stack stack = new Stack();
        int amountToPush = 15;

        for (int i = 0; i < amountToPush; i++) {
            stack.push(i);
        }
        assertEquals(amountToPush, stack.count());
    }

    @Test
    void popOneValueTest() {
        Stack stack = new Stack();
        stack.push("String");
        stack.pop();
        assertEquals(0, stack.count());
    }

    @Test
    void pushMultiplePopMultipleButNotAllTest() {
        int amountToPush = 50000;
        int amountToPop = 10000;
        Stack stack = new Stack();
        pushPopMultiple(stack, amountToPush, amountToPop);
        int expectedValue = amountToPush >= amountToPop ? amountToPush - amountToPop : 0;
        assertEquals(expectedValue, stack.count());
    }

    @Test
    void pushMultiplePopMultipleMoreThanExistsTest() {
        int amountToPush = 5;
        int amountToPop = 6;
        Stack stack = new Stack();
        pushPopMultiple(stack, amountToPush, amountToPop);
        assertEquals(0, stack.count());
    }

    void pushPopMultiple(Stack stack, int amountToPush, int amountToPop) {
        for (int i = 0; i < amountToPush; i++) {
            stack.push(i);
        }

        for (int i = 0; i < amountToPop; i++) {
            stack.pop();
        }
    }

    @Test
    void pushMultipleCountTest() {
        int amountToPush = 13;
        int amountToPop = 0;
        Stack stack = new Stack();
        pushPopMultiple(stack, amountToPush, amountToPop);
        int expectedValue = amountToPush >= amountToPop ? amountToPush - amountToPop : 0;
        assertEquals(expectedValue, stack.count());
    }

    @Test
    void emptyTest() {
        Stack stack = new Stack();
        stack.push("String");
        assertEquals(false, stack.empty());
    }

    @Test
    void multipleTypeTest() {
        Stack stack = new Stack<>();
        stack.push("asd");
        stack.push(2);
        stack.push('c');
        stack.push(new Stack<String>());
        stack.pop();
        stack.pop();
        assertEquals(2, stack.count());
    }

    @Test
    void poppingFromEmptyStackTest()
    {
        Stack stack = new Stack();
        Object poppedItem = stack.pop();
        assertNull(poppedItem);
    }

    @Test
    void pushingNullTest()
    {
        Stack stack = new Stack();
        stack.push(null);
        assertEquals(0, stack.count());
    }

    @Test
    void pushingTenMillion()
    {
        int maxAmountOfItems = 10000000;
        Stack stack = new Stack();
        for (int x=0;x<maxAmountOfItems;x++)
        {
            stack.push(x);
        }
        assertEquals(maxAmountOfItems, stack.count());
    }
}