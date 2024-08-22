package faang.school.godbless.Big_Bang_Theory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println("Begin " + name + " " + task);
            Thread.sleep(1000);
            System.out.println(task +" has been completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
