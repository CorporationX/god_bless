package faang.school.godbless.tamagochi;

import lombok.Data;

@Data
public class TamagotchiVlad {
    private static int counter;
    private int id = counter; // при создании объекта TamagochiVlad статическая переменная инкрементируется и id получает ее значение

    public TamagotchiVlad() {
        counter++;
    }

    public synchronized void feed() {
        makeDelay();
        System.out.println("Feeding Vlad #" + id);
    }

    public synchronized void play() {
        makeDelay();
        System.out.println("Playing with Vlad #" + id);
    }

    public synchronized void clean() {
        makeDelay();
        System.out.println("Cleaning Vlad #" + id);
    }

    public synchronized void sleep() {
        makeDelay();
        System.out.println("Vlad #" + id + " is sleeping");
    }

    private void makeDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
