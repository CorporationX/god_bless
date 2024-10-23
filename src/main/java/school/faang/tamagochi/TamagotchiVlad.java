package school.faang.tamagochi;

import lombok.Getter;

@Getter
public class TamagotchiVlad {
    String name;
    String state;

    public TamagotchiVlad(String name) {
        this.name = name;
        state = "Скучает";
    }

    public synchronized void feed() {
        printAction("ест");
        state = "Сыт";
        printState();
    }

    public synchronized void play() {
        printAction("играет");
        state = "Весел";
        printState();
    }

    public synchronized void clean() {
        printAction("моется");
        state = "Чистый";
        printState();
    }

    public synchronized void sleep() {
        state = "Устал";
        printState();
        printAction("спит");
    }

    private void printState() {
        System.out.println(Thread.currentThread().getName() + " " + name + " " + state);
    }

    private void printAction(String action) {
        System.out.println(Thread.currentThread().getName() + " " + name + " " + action);
    }
}

