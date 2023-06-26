package faang.school.godbless.sprint3.bigBang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;
    @Override
    public void run() {
        System.out.println(String.format("%s работает над %s", name, task));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println(String.format("%s завершил %s", name, task));
        }
    }
}
