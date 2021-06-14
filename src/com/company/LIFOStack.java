package com.company;

class LIFOStack<E> implements IStack<E> {
    private Object[] underlyingArray;
    private int tailIndex;
    private final int initialStackSize = 100;

    public LIFOStack() {
        underlyingArray = new Object[initialStackSize];
        tailIndex = -1;
    }

    @Override
    public void push(E item) {
        if (item != null) {
            try {
                int length = underlyingArray.length;
                if (tailIndex >= length - 1) {
                    int newLength = tailIndex == -1 ? initialStackSize : length * 2;
                    underlyingArray = copyItems(underlyingArray, newLength, length);
                }
                tailIndex += 1;
                underlyingArray[tailIndex] = item;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public E pop() {
        int length = underlyingArray.length;
        if (tailIndex == -1) {
            return null;
        }

        try {
            Object poppedItem = underlyingArray[tailIndex];
            tailIndex -= 1;

            if (tailIndex < length / 2) {
                underlyingArray = copyItems(underlyingArray, tailIndex + 1, tailIndex);
            }
            return (E) poppedItem;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public boolean empty() {
        return tailIndex == -1;
    }

    @Override
    public int count() {
        return tailIndex + 1;
    }

    private E[] copyItems(Object[] sourceArray, int newLength, int counterAmount) {
        try {
            Object[] newArray = new Object[newLength];
            for (int i = 0; i < counterAmount; i++) {
                newArray[i] = sourceArray[i];
            }
            return (E[]) newArray;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String toString() {
        return "StackDataStructure";
    }
}
