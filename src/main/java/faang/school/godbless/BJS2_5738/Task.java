package faang.school.godbless.BJS2_5738;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнять задание: " + task);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            System.out.println("Выполнение " + task + " было прервано");
        }
        System.out.println(name + " выполнил задание: " + task);
    }
}
