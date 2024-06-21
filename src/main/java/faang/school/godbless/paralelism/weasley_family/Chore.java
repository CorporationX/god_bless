package faang.school.godbless.paralelism.weasley_family;

public class Chore implements Runnable {
    private String chore;
    private final Long TASK_DURATION = 1000L;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        System.out.println(String.format("The %s performed in %s.", this.chore, nameThread));
        try {
            Thread.sleep(TASK_DURATION);
            System.out.println(String.format("The %s complete in %s.", this.chore, nameThread));
        } catch (InterruptedException e) {
            System.out.println(String.format("The %s interrupted!", nameThread));
            ;
        }
    }
}
