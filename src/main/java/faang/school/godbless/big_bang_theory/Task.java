package faang.school.godbless.big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task implements Runnable {

    private String name;
    private String task;

    public Task(String name, String task) {  //@AllArgsConstructor didn't work properly, пришлось объявить конструкток так
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {

        System.out.println("Task " + task + " " + "started execution by " + name);
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " executing task" + i);
                Thread.sleep(1000);
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Task" + task + "interrupted " + name);
            e.printStackTrace();
        }
        System.out.println("Task " + task + " finished by " + name);
    }
}
