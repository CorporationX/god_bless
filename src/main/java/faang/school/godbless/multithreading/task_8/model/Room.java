package faang.school.godbless.multithreading.task_8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private final String name;
    private final List<Food> foods;
}