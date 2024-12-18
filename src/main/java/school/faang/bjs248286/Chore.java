package school.faang.bjs248286;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);

    }
}
