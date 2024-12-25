package school.faang.sprint4.task_50824;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@ToString
public class Student {
    private final String name;
    private final int year;
    @Getter
    private AtomicInteger points = new AtomicInteger(0);
}
