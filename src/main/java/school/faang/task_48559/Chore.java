package school.faang.task_48559;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        if (chore == null || chore.trim().isEmpty()) {
            throw new IllegalArgumentException("Задача не может быть пустой");
        }
        this.chore = chore;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " делаю задачу: " + getChore());
        try {
            Thread.sleep(1000);
            System.out.println("Задача " + chore + " выполнена");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " не выполнена");
        }
    }

    public String getChore() {
        return chore;
    }
}



