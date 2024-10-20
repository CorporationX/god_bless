package school.faang_sprint_3.very_nice_but_poor;

public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " doing task " + chore);
            Thread.sleep(5000);
            System.out.println(chore + " has been done");
        } catch (InterruptedException e) {
            System.out.println("Task " + chore + " wasn't done");
        }
    }
}
