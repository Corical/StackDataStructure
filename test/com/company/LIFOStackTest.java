package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LIFOStackTest {

    @Test
    void pushOneValueTest() {
        LIFOStack lifoStack = new LIFOStack();
        lifoStack.push("String");
        assertEquals(1, lifoStack.count());
    }

    @Test
    void pushMultipleValuesTest() {
        LIFOStack lifoStack = new LIFOStack();
        int amountToPush = 15;

        for (int i = 0; i < amountToPush; i++) {
            lifoStack.push(i);
        }
        assertEquals(amountToPush, lifoStack.count());
    }

    @Test
    void popOneValueTest() {
        LIFOStack lifoStack = new LIFOStack();
        lifoStack.push("String");
        lifoStack.pop();
        assertEquals(0, lifoStack.count());
    }

    @Test
    void pushMultiplePopMultipleButNotAllTest() {
        int amountToPush = 50000;
        int amountToPop = 10000;
        LIFOStack lifoStack = new LIFOStack();
        pushPopMultiple(lifoStack, amountToPush, amountToPop);
        int expectedValue = amountToPush >= amountToPop ? amountToPush - amountToPop : 0;
        assertEquals(expectedValue, lifoStack.count());
    }

    @Test
    void pushMultiplePopMultipleMoreThanExistsTest() {
        int amountToPush = 5;
        int amountToPop = 6;
        LIFOStack lifoStack = new LIFOStack();
        pushPopMultiple(lifoStack, amountToPush, amountToPop);
        assertEquals(0, lifoStack.count());
    }

    void pushPopMultiple(LIFOStack lifoStack, int amountToPush, int amountToPop) {
        for (int i = 0; i < amountToPush; i++) {
            lifoStack.push(i);
        }

        for (int i = 0; i < amountToPop; i++) {
            lifoStack.pop();
        }
    }

    @Test
    void pushMultipleCountTest() {
        int amountToPush = 13;
        int amountToPop = 0;
        LIFOStack lifoStack = new LIFOStack();
        pushPopMultiple(lifoStack, amountToPush, amountToPop);
        int expectedValue = amountToPush >= amountToPop ? amountToPush - amountToPop : 0;
        assertEquals(expectedValue, lifoStack.count());
    }

    @Test
    void emptyTest() {
        LIFOStack lifoStack = new LIFOStack();
        lifoStack.push("String");
        assertEquals(false, lifoStack.empty());
    }

    @Test
    void multipleTypeTest() {
        LIFOStack lifoStack = new LIFOStack<>();
        lifoStack.push("asd");
        lifoStack.push(2);
        lifoStack.push('c');
        lifoStack.push(new LIFOStack<String>());
        lifoStack.pop();
        lifoStack.pop();
        assertEquals(2, lifoStack.count());
    }

    @Test
    void poppingFromEmptyStackTest()
    {
        LIFOStack lifoStack = new LIFOStack();
        Object poppedItem = lifoStack.pop();
        assertNull(poppedItem);
    }

    @Test
    void pushingNullTest()
    {
        LIFOStack lifoStack = new LIFOStack();
        lifoStack.push(null);
        assertEquals(0, lifoStack.count());
    }

    @Test
    void pushingTenMillion()
    {
        int maxAmountOfItems = 10000000;
        LIFOStack lifoStack = new LIFOStack();
        for (int x=0;x<maxAmountOfItems;x++)
        {
            lifoStack.push(x);
        }
        assertEquals(maxAmountOfItems, lifoStack.count());
    }

    @Test
    void copyItemsReduceTest()
    {
        LIFOStack lifoStack = new LIFOStack();
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        Object[] objects = lifoStack.copyItems(stringList.toArray(), 1, 1);
        assertEquals(1, objects.length);
    }

    @Test
    void copyItemsIncreaseTest()
    {
        LIFOStack lifoStack = new LIFOStack();
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        Object[] objects = lifoStack.copyItems(stringList.toArray(), 5, 1);
        assertEquals(5, objects.length);
    }

    @Test
    void copyMoreItemsThanNewLengthTest()
    {
        LIFOStack lifoStack = new LIFOStack();
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        assertThrows(IndexOutOfBoundsException.class, () -> lifoStack.copyItems(stringList.toArray(), 2, 5));
    }
}