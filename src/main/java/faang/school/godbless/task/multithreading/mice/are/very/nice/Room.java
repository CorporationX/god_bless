package faang.school.godbless.task.multithreading.mice.are.very.nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Room {
    private final String name;
    private final List<Food> foods;
}
