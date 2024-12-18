package school.faang.bjs248950;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : executing task: " + chore);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : task finished: " + chore);
    }

}
