package school.faang.BJS236679;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Раб " + name + " начинает работать над: " + task);
        System.out.println();
        try {
            System.out.println("Раб " + name + " Раб думает над: " + task);
            System.out.println();
            Thread.sleep(5000);
            System.out.println();
            System.out.println("Раб " + name + " сделал работу: " + task);
        } catch (InterruptedException e) {
            System.out.println("Что то пошло не так " + e);
            e.printStackTrace();
        }
    }
}
