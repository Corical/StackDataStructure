package com.company;

class Stack<E> {
    private Object[] _underlyingArray;
    private int tailIndex;
    private int initialStackSize = 100;

    public Stack() {
        _underlyingArray = new Object[initialStackSize];
        tailIndex = -1;
    }

    public void push(E item) {
        if (item != null) {
            try {
                int length = _underlyingArray.length;
                if (tailIndex >= length - 1) {
                    int newLength = tailIndex == -1 ? initialStackSize : length * 2;
                    _underlyingArray = copyItems(_underlyingArray, newLength, length);
                }
                tailIndex += 1;
                _underlyingArray[tailIndex] = item;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public E pop() {
        int length = _underlyingArray.length;
        if (tailIndex == -1) {
            return null;
        }

        try {
            Object poppedItem = _underlyingArray[tailIndex];
            tailIndex -= 1;

            if (tailIndex < length / 2) {
                _underlyingArray = copyItems(_underlyingArray, tailIndex + 1, tailIndex);
            }
            return (E) poppedItem;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean empty() {
        return tailIndex == -1;
    }

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
