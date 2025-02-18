package school.faang.chores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is doing " + getTitle());
        Thread.sleep(1000);
    }
}
