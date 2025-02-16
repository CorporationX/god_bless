package school.faang.sprint2.task_BJS2_60200.palindrome.number;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Figure {
    private int val;
    private Figure next;

    public Figure(int val) {
        this.val = val;
    }

    public void increment() {
        val++;
        if (val == 10) {
            val = 0;
            incrementNext();
        }
    }

    public StringBuilder getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        if (next != null) {
            builder.append(next.getSequence());
        }
        return builder;
    }

    private void incrementNext() {
        if (next == null) {
            next = new Figure();
        }
        next.increment();
    }
}
