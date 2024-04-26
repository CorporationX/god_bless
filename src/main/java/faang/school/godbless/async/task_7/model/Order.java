package faang.school.godbless.async.task_7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {
    private final int id;
    private boolean processed;

    public void processed() {
        processed = true;
    }
}