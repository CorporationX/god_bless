package src.main.java.faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MessageFilter> filters = Arrays.asList(
                message -> message.length() > 77,
                message -> message.contains("java")
        );
    }
}
