package faang.school.godbless.sprint4_multithreading.theory;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task implements Runnable{
    String name;
    String task;
    @Override
    public void run(){
        System.out.println(getName()+" начал выполнения задания: "+ getTask());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(getName()+" закончил выполнения задания: "+ getTask());
    }
}
