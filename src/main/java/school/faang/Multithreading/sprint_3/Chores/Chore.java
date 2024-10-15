package school.faang.Multithreading.sprint_3.Chores;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            System.out.println("Задача " + "не выполнилась");
        }
    }
}
