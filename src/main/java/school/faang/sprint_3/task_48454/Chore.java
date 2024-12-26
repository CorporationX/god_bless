package school.faang.sprint_3.task_48454;


public class Chore implements Runnable {


    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Выполняет задачу " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " - выполнена");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана");
        }
    }
}
