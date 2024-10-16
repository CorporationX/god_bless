package school.faang.family;

public class Chore implements Runnable {
    private String nameTask;

    public Chore(String nameTask) {
        this.nameTask = nameTask;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " взял задачу " + nameTask + " в работу");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " выполнил задачу " + nameTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

