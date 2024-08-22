package faang.school.godbless.BJS2_24207;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chroe;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
