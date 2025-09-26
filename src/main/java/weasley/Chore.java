package weasley;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Chore implements Runnable {
    private String task;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
