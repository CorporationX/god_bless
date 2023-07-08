package faang.school.godbless.Multithreading.ParallelismAndThread.task06_TheBigBangTheory;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(this.name + " делает задачу - " + this.task );
        try {
            Thread.sleep(10000);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}
