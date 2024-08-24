package thread.four;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task implements Runnable {

    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнять свое задание " + task + ".");

        try {
            Thread.sleep(2000);
            System.out.println(name + " закончил свою работу.");
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время выполнения задания " + task + ".");
        }
    }
}
