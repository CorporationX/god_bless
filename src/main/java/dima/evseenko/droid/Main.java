package dima.evseenko.droid;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        DroidMessageHandler messageHandler = (from, to, message) -> System.out.printf("Дроид %s получил и расшифровал сообщение от %s: %s%n", to.getName(), from.getName(), message);

        Droid petya = new Droid("Petya");
        petya.setMessageHandler(messageHandler);

        Droid vasya = new Droid("Vasya");
        vasya.setMessageHandler(messageHandler);

        Droid dima = new Droid("Dima");
        dima.setMessageHandler(((from, to, message) -> {
            System.out.println("Дима получил сообщение: " + message);
        }));

        dima.sendMessage(vasya, "hello", KeyGenerator.getInstance("AES").generateKey());
        petya.sendMessage(dima, "Join the Rebellion!", KeyGenerator.getInstance("AES").generateKey());
        vasya.sendMessage(petya, "The mission is complete.", KeyGenerator.getInstance("AES").generateKey());
    }
}
