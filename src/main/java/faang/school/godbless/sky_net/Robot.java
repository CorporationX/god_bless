package faang.school.godbless.sky_net;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String name;
    private Target target;

    public void attack() {
        synchronized (target) {
            if(target.isAlive()) {
                System.out.println(name + " destroyed " + target.getName());
                target.setAlive(false);
            } else {
                try {
                    target.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
