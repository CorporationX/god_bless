package faang.school.godbless.BJS2_12442;

public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name , String task){
    this.name = name;
    this.task = task;
    }

    @Override
    public void run(){
        System.out.println(getName() + " " + getTask());
        try{
            Thread.sleep(3500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(getName() + " completed the " + getTask());
    }

    public String getTask() {
        return task;
    }

    public String getName() {
        return name;
    }
}
