package faang.school.godbless.they_were_very_nice;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000);
    }
}
