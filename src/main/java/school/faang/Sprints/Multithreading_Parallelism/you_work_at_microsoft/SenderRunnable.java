package school.faang.Sprints.Multithreading_Parallelism.you_work_at_microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = this.getStartIndex(); i < this.getEndIndex(); i++) {
            System.out.println(i + "Massage was sent");
        }
    }
}
