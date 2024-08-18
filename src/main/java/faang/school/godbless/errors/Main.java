package faang.school.godbless.errors;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Handling<String> handling = new Handling();
        AtomicReference<Integer> integer = new AtomicReference<>(Integer.valueOf(1234));


        //работа не аварийна€
        handling.withErrorHandling(() -> {
                    System.out.println("Ѕазова€ работа программы, проверка замыкани€: ");
                    System.out.println("значение до: " + integer);
                    integer.updateAndGet(v -> v - 123);
                    System.out.println("значение после: " + integer);
                    return "nice";
                },
                e -> "not nice"
        );

        //работа аварийна€
        handling.withErrorHandling(() -> {
                    throw new RuntimeException();
                },
                e -> {
                    System.out.println("јварийна€ работа программы, проверка замыкани€: ");
                    System.out.println("значение до: " + integer);
                    integer.updateAndGet(v -> v - 123);
                    System.out.println("значение после: " + integer);
                    return "not nice";
                }
        );
    }
}

