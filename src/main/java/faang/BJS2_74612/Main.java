package faang.BJS2_74612;

import lombok.SneakyThrows;

import java.util.concurrent.Future;

public final class Main {
    @SneakyThrows
    public static void main(final String[] args) {
        final Robot first = new Robot("Daniyal", 2, 3);
        final Robot second = new Robot("Lada", 1, 2);
        final Battle battle = new Battle();

        final Future<Robot> fightResult = battle.fight(first, second);
        final Robot winner = fightResult.get();

        System.out.println(winner);
    }
}

