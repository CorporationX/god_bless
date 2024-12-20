package school.faang.sprint3.task48474theywerenice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + this.getChore());
        Thread.sleep(20);
    }
}
