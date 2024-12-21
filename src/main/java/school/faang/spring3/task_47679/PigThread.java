package school.faang.spring3.task_47679;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class PigThread extends Thread {
    protected String name;
    protected String material;

    public void buildHouse(int delay) {
        System.out.println(name + " начал строить дом из " + material);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " закончил строить дом из " + material);
    }
}
