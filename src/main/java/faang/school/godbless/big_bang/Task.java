package faang.school.godbless.big_bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Getting to do: " + task);
        try{
            Thread.sleep(500);
        } catch (InterruptedException ex){
            ex.getStackTrace();
            System.out.println("Task interrupted");
        }

        System.out.println(task + " is finished");
    }
}
