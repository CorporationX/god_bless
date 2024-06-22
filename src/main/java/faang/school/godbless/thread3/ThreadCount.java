package faang.school.godbless.thread3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ThreadCount extends Thread {
    @Override
    public void run() {
        super.run();
    }

    private int count;
}
