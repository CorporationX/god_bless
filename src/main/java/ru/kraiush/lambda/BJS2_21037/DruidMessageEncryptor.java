package ru.kraiush.lambda.BJS2_21037;

@FunctionalInterface
public interface DruidMessageEncryptor {

    String getMessage(String message, int key);
}
