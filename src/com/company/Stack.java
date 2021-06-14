package com.company;

class Stack<E> {
    private Object[] _underlyingArray;

    public Stack() {
        _underlyingArray = new Object[0];
    }

    public void push(E item) {
        if (item != null)
        {
            try
            {
                int length = _underlyingArray.length;
                _underlyingArray = copyItemsForPush(_underlyingArray);
                _underlyingArray[length] = item;
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
    }

    public E pop() {
        int length = _underlyingArray.length;
        if (length == 0) {
            return null;
        }

        try {
            Object poppedItem = _underlyingArray[length - 1];
            _underlyingArray = copyItemsForPop(_underlyingArray);
            return (E) poppedItem;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean empty() {
        return _underlyingArray.length == 0;
    }

    public int count() {
        return _underlyingArray.length;
    }

    private E[] copyItemsForPush(Object[] sourceArray) {
        return copyItems(sourceArray, sourceArray.length + 1, sourceArray.length);
    }

    private E[] copyItemsForPop(Object[] sourceArray) {
        return copyItems(sourceArray, sourceArray.length - 1, sourceArray.length - 1);
    }

    private E[] copyItems(Object[] sourceArray, int newLength, int counterAmount) {
        try
        {
            Object[] newArray = new Object[newLength];
            for (int i = 0; i < counterAmount; i++) {
                newArray[i] = sourceArray[i];
            }
            return (E[]) newArray;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public String toString() {
        return "StackDataStructure";
    }
}
