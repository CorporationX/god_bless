package school.faang.theywerevnicebutextrpoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is performing the task: " + chore);
            Thread.sleep(2000); // Delay of 2 seconds to show task execution
            System.out.println(Thread.currentThread().getName() + " has completed the task: " + chore);
        } catch (InterruptedException e) {
            System.err.println("The task was interrupted: " + chore);
            Thread.currentThread().interrupt();
        }
    }
}
