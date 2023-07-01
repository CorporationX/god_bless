package faang.school.godbless.nice_but_poot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        System.out.println("Chore to do: " + chore + ". " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(chore + " done");
    }
}
