package faang.school.godbless.sprint_3.multithreading.tamagochi_vlad;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamagotchiVlad {
    private int index;

    public synchronized void feed() {
        System.out.println("Кормим Влада № " + index);
    }

    public synchronized void play() {
        System.out.println("Playing with Vlad # " + index);
    }

    public synchronized void clean() {
        System.out.println("Убираем за Владом под номером " + index);
    }

    public synchronized void sleep() {
        System.out.println("Говорим Владу # " + index + " идти спать");
    }
}
