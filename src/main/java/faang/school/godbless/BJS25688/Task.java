package faang.school.godbless.BJS25688;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начинает выполнение задания: " + task);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(name + " задача была прервана!");
            return;
        }
        System.out.println(name + " завершил выполнение задания: " + task);
    }
}
