package faang.school.godbless.SkyNet;

import lombok.Data;

@Data
public class Robot implements Runnable {
    private int targetID;

    public Robot(int targetID) {
        this.targetID = targetID;
    }

    public void attack() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " target# " + getTargetID() + " is under attack");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        attack();
    }
}

