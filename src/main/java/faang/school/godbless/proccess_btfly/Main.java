package faang.school.godbless.proccess_btfly;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var resultNull = ExceptionProcessor.process(new ArrayList<Integer>(),
                (list) -> list.get(3),
                (exception) -> {
                    log.error("Caught and exception: {}", exception.getMessage());
                    return "DEFAULT";
                });

        System.out.println(resultNull);

        var resultDouble = ExceptionProcessor.process(Arrays.asList(1.2, 2.3, 3.4, 4.5),
                (list) -> list.get(3),
                (exception) -> {
                    log.error("Caught and exception: {}", exception.getMessage());
                    return "DEFAULT";
                });
        System.out.println(resultDouble);
    }
}
