package ru.kraiush.threads.BJS2_23511;

import java.util.concurrent.Callable;

public class Army implements Callable {

    private Character hero;

    public Army(Character hero) {
        this.hero = hero;
    }

    @Override
    public Integer call() throws Exception {
        return hero.getPower();
    }
}
