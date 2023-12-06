package faang.school.godbless.work.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;
    private List<Integer> list;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Letter #" + list.get(i) + " send successfully!");
        }
    }
}
