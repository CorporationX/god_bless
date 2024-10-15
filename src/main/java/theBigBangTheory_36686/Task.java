package theBigBangTheory_36686;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;


    @Override
    public void run() {
        System.out.println( name + " приступил к работе над " + task);
        try {
            Thread.sleep(1000);
            System.out.println(name + " выполнил своё задание: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " не выполнил своё задание " + task);
        }
    }
}
