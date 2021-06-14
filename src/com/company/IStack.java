package com.company;

public interface IStack<E> {
    void push(E item);

    E pop();

    boolean empty();

    int count();
}
