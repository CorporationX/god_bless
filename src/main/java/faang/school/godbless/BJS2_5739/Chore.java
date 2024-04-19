package faang.school.godbless.BJS2_5739;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " взято в работу - " + chore);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println(chore + " - сделано");
    }
}
