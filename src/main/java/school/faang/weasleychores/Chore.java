package school.faang.weasleychores;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements  Runnable{
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Chore is being done: " + chore + " | Stream number: "  + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Chore " + chore + " is done");
        } catch (InterruptedException e) {
            System.out.println("The chore " + chore + " was interrupted");
        }
    }
}
