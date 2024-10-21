package school.faang.weasley.family;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.printf("%s is now run \"%s\" task\n", Thread.currentThread().getName(), chore);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
