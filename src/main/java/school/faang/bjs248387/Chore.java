package school.faang.bjs248387;

import lombok.Data;

@Data
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " : " + chore);
            Thread.sleep(2000);
            System.out.println(chore + " task end");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
