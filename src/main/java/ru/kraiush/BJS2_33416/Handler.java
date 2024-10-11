package ru.kraiush.BJS2_33416;

@FunctionalInterface
public interface Handler<T> {
    T handle(Exception e);
}
