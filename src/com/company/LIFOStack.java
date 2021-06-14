package com.company;

class LIFOStack<E> implements IStack<E> {
    private Object[] underlyingArray;
    private int tailIndex;
    private final int initialStackSize = 100;

    public LIFOStack() {
        underlyingArray = new Object[initialStackSize];
        tailIndex = -1;
    }

    /**
     * Pushed an element on to the array, will increase the underlyingArray if there is insufficient space
     * @param item element to be pushed on to array
     */
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

    /**
     * Pops an element from the array and decrease underlyingArray size if filled below a certain threshold
     * @return element that was popped from the array
     */
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

    /**
     * Check to see if the stack is empty, -1 tailIndex means it is empty
     * @return
     */
    @Override
    public boolean empty() {
        return tailIndex == -1;
    }

    /**
     * Returns the current size of the array (this is not the actual size but a maintained size through tailIndex)
     * @return last index of the stack
     */
    @Override
    public int count() {
        return tailIndex + 1;
    }

    /**
     * Made public for the tests
     * @param sourceArray array to copy elements from
     * @param newArrayLength the length of the new array being created
     * @param amountOfElementsToCopy the amount of elements that need to be copied over to to new, from the old
     * @return newly create array with items copied
     */

    public E[] copyItems(Object[] sourceArray, int newArrayLength, int amountOfElementsToCopy) {
        try {

            if (amountOfElementsToCopy > newArrayLength)
                throw new IndexOutOfBoundsException();

            Object[] newArray = new Object[newArrayLength];
            for (int i = 0; i < amountOfElementsToCopy; i++) {
                newArray[i] = sourceArray[i];
            }
            return (E[]) newArray;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
