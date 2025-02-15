package school.faang.sprint2.task_BJS2_60200.palindrome;

import lombok.Getter;

@Getter
public class Figure {
    private int val = 1;
    private Figure next;

    public void increment() {
        val++;
        if (val == 10) {
            val = 0;
            next = new Figure();
            next.increment();
        }
    }

    public StringBuilder getSequence() {
        StringBuilder builder = new StringBuilder();
        if (next != null) {
            builder.append(next.getSequence());
        }
        return builder;
    }
}
