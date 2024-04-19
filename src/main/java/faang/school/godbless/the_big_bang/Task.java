package faang.school.godbless.the_big_bang;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнение задания: " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " прервал выполнение задания: " + task);
            return;
        }
        System.out.println(name + " завершил выполнение задания: " + task);
    }
}
