package faang.school.godbless.HandleErrors;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(RemoteService.withErrorHandling(() -> "Value", (exception) -> ""));

        List<String> list = new ArrayList<>();
        System.out.println(RemoteService.withErrorHandling(
                () -> list.get(0),
                (exception) -> {
                    System.out.println(exception.getMessage());
                    return "default";
                })
        );
    }
}
