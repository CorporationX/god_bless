package they_were_very_nice_but_extremely_poor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    /**
     * A method that needs to be implemented for {@link Runnable} interface.
     * It is called when the {@link Thread} is started.
     * <p>
     * This method prints out a message saying that the thread is running,
     * waits for 1 second, and then prints out another message saying
     * that the thread is done.
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running: " + chore);
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " is done: " + chore);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted: " + chore);
        }
    }
}
