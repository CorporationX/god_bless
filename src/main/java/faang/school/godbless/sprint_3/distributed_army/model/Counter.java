package faang.school.godbless.sprint_3.distributed_army.model;

import lombok.Data;

@Data
public class Counter {
    private int totalCount;

    public void increment(int number) {
        totalCount += number;
    }
}