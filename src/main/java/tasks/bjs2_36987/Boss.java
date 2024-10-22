package tasks.bjs2_36987;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Boss {
    private int health = 100;
    private int maxBattlingPlayers = 12;
    private List<Player> battlingPlayers = new ArrayList<>();
    private List<Player> deadPlayers = new ArrayList<>();
    private boolean isDead = false;
    private final ScheduledExecutorService battleScheduler = Executors.newScheduledThreadPool(1);
    private final ScheduledExecutorService addingPlayerScheduller = Executors.newScheduledThreadPool(maxBattlingPlayers);

    public static void main(String[] args) {
        Boss boss = new Boss();
        List<Player> players = IntStream.range(1, 101)
            .mapToObj(i -> new Player("Player_" + i))
            .toList();

        players.forEach(player ->
            boss.addingPlayerScheduller.schedule(() ->
                player.startBattle(boss), 1, TimeUnit.SECONDS)
        );

        boss.battleScheduler.scheduleWithFixedDelay(boss::battle, 5, 1, TimeUnit.SECONDS);

        try {
            if (boss.battleScheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                boss.endBattle();
                boss.showBattleResult(players);
            } else {
                boss.endBattle();
                System.out.println("Игроки не смогли справиться с босом за отведенное время. Битва остановлена");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("В процессе выполнения программы произошла ошибка: " + e.getMessage());
        }
    }

    private void battle() {
        System.out.println("Сражение началось");

        synchronized (battlingPlayers) {
            takeDamage(battlingPlayers.size());

            if (isBattleOver())
                endBattle();
        }
    }

    public synchronized void joinBattle(Player player) {
        while(battlingPlayers.size() >= maxBattlingPlayers) {
            try {
                player.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if(!isDead) {
            battlingPlayers.add(player);
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (!isDead) {
            deadPlayers.add(player);
            battlingPlayers.remove(player);
        }
    }

    private void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;
            System.out.println("Босу нанесли урон : " + damage + ". Здоровье после атаки : " + health);
        } else {
            System.out.println("В группе нет игроков для битвы с боссом");
        }
    }

    private boolean isBattleOver() {
        boolean isBossDead = isDead = health <= 0;
        boolean arePlayersAbsent = battlingPlayers.size() == 0 && health > 0;

        return isBossDead || arePlayersAbsent;
    }

    private void endBattle() {
        battleScheduler.shutdownNow();
        addingPlayerScheduller.shutdownNow();
    }

    private void showBattleResult(List<Player> allPlayers) {
        System.out.println("Сводка по сражению :");

        if(isDead) {
            System.out.println("Босс повержен. Победили игроки!");
        } else {
            System.out.println("Игроки повержены. Победил Босс!");
        }

        System.out.println();
        System.out.println("Сводка по игрокам : ");
        System.out.println("\n Славные бойцы, погубившние боса : ");
        battlingPlayers.forEach(System.out::println);
        System.out.println("\n Павшие бойцы : ");
        deadPlayers.forEach(System.out::println);
        System.out.println("\n Ждуньки : ");
        allPlayers
            .stream()
            .filter(player -> !battlingPlayers.contains(player) && !deadPlayers.contains(player))
            .forEach(System.out::println);
    }
}
