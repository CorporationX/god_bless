package school.faang.weasley_chores;

public class Chore implements  Runnable {
    private String taskTitle;

    public Chore(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working on the task " + taskTitle);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hometask " + taskTitle + " was made");
    }
}
