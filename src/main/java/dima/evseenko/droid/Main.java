package dima.evseenko.droid;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Droid petya = new Droid("Petya");
        Droid vasya = new Droid("Vasya");
        Droid dima = new Droid("Dima");
        dima.setMessageHandler(((from, message) -> {
            System.out.println("Дима получил сообщение: " + message);
        }));

        dima.sendMessage(vasya, "hello", KeyGenerator.getInstance("AES").generateKey());
        petya.sendMessage(dima, "Join the Rebellion!", KeyGenerator.getInstance("AES").generateKey());
        vasya.sendMessage(petya, "The mission is complete.", KeyGenerator.getInstance("AES").generateKey());
    }
}
