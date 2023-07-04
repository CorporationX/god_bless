package main.java.faang.school.godbless.sprint3_lambda.error;

import java.util.List;
import java.util.Random;

public class Main {
    private List<String> list = List.of("1", "hello", "2", "sup", "hey", "3", "4");


    public static void main(String[] args) {
        String someString = ErrorHandler.withErrorHandling(
                () -> new Main().getString(), exception -> {
                    exception.printStackTrace();
                    return "Bottle of water";
                });
        System.out.println(someString);
    }

    public String getString() {
        int randomNumber = new Random().nextInt();
        return list.get(randomNumber);
    }
}