package faang.school.godbless.Big.Bang.Theory;

import lombok.Getter;

@Getter
public class Task implements Runnable {
    private String name;
    private String task;
    private String status = "не завершена";

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " начал делать задание: " + task);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            status = "завершена";
            System.out.println(name + " завершил задание: " + task);
        } catch (Exception e) {
            System.out.println(name + " не завершил задание: " + task);
        }
    }

}
