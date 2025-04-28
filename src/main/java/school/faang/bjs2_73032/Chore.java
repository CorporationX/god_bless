package school.faang.bjs2_73032;

import lombok.Data;

@Data
public class Chore implements Runnable {
    private String choreName;

    public Chore(String choreName) {
        this.choreName = choreName;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().setName(choreName + "Thread started");
            System.out.printf("Performing task %s\n", choreName);
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(choreName + " finished");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread interrupted");
        }
    }
}
