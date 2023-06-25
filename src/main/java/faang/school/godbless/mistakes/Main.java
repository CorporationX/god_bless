package faang.school.godbless.mistakes;

import java.util.*;
import java.util.function.Function;

public class Main<T> {
    public static void main(String[] args) {
        Handling handling = new Handling();
        List<Integer> list = new ArrayList<>();
        Handling.withErrorHandling(() -> list.get(1),
                e -> {
                    throw new NullPointerException();
                });
    }
}
