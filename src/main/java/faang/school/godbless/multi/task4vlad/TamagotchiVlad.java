package faang.school.godbless.multi.task4vlad;

import lombok.Data;

@Data

public class TamagotchiVlad {
    private String name;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        System.out.println(name + " покормлен.");
    }

    public synchronized void play() {
        System.out.println(name + " поигран.");
    }

    public synchronized void clean() {
        System.out.println(name + " помыт.");
    }

    public synchronized void sleep() {
        System.out.println(name + " поспат.");
    }
}

