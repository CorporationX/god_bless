package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        try{
            System.out.printf("%s начал выполнять задачу: %s\n", name, task);
            System.out.printf("Задача %s выполняется ...\n", task);
            Thread.sleep(1000);
            System.out.printf("%s завершил %s\n", name, task);
        } catch (InterruptedException e){
            System.out.printf("Task %s was failed according: %s\n", task, e);
            throw new RuntimeException(e);
        }
    }
}
