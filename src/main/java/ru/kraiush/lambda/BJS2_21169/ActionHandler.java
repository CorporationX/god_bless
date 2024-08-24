package ru.kraiush.lambda.BJS2_21169;

@FunctionalInterface
public interface ActionHandler<T, R> {

     R apply(T t);
}
