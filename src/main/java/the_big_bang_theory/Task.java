package the_big_bang_theory;

public class Task implements Runnable{
    private String name;
    private String task;
    public Task(String name, String task){
        this.name = name;
        this.task = task;
    }
    public void run(){
        System.out.println(name+" began to carry out his task");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("The task was aborted");
        }
        System.out.println(name+" has completed his task");
    }
}
