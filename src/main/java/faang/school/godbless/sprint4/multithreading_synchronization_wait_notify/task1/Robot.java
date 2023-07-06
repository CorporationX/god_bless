package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {

    private String target;

    public synchronized void attack() {
        System.out.println(Thread.currentThread().getName() + " Robot is attacking " + target);
    }
}
