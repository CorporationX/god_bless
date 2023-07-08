package faang.school.godbless.tamagotchi;

import lombok.Data;

@Data
public class TamagotchiVlad {
    private String name;

    public TamagotchiVlad(String name) {
        this.name = name + " Vlad";
    }

    public void feed() {
        System.out.println("Вы покормили " + getName());
    }

    public void play() {
        System.out.println("Вы поиграли с " + getName());
    }

    public void clean() {
        System.out.println("Вы почистили " + getName());
    }

    public void sleep() {
        System.out.println("ложится спать~ " + getName());
    }
}

