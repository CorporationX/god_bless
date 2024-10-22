package tasks.bjs2_36987;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class Game {
    private Boss boss;
    private List<Player> players;
    private List<Player> battlingPlayers;
    private List<Player> deadPlayers;
    private int maxBattlingPlayers;
    private int maxPlayers;
    private ScheduledExecutorService battleTask;
    private ScheduledExecutorService addingPlayerTask;
    private final int MAX_BATTLE_TIME = 1;
    private final TimeUnit BATTLE_TIME_UNIT = TimeUnit.MINUTES;

    public Game(int maxBattlingPlayers, int maxPlayers, int bossHealth) {
        this.maxBattlingPlayers = maxBattlingPlayers;
        this.maxPlayers = maxPlayers;
        this.boss = new Boss(bossHealth);
        players = IntStream.range(0, this.maxPlayers).mapToObj(i -> new Player("Player_" + (i + 1))).toList();
        battlingPlayers = new ArrayList<>();
        deadPlayers = new ArrayList<>();
        battleTask = Executors.newScheduledThreadPool(1);
        addingPlayerTask = Executors.newScheduledThreadPool(maxBattlingPlayers);
    }

    public static void main(String[] args) {
        Game game = new Game(10, 20, 100);

        game.players.forEach(player ->
            game.addingPlayerTask.schedule(() ->
                player.startBattle(game), 1, TimeUnit.SECONDS)
        );

        game.battleTask.scheduleWithFixedDelay(game::battle, 1, 1, TimeUnit.SECONDS);

        try {
            if (game.battleTask.awaitTermination(game.MAX_BATTLE_TIME, game.BATTLE_TIME_UNIT)) {
                game.endBattle();
                game.showBattleResult();
            } else {
                game.endBattle();
                System.out.println("Игроки не смогли справиться с босом за отведенное время. Битва остановлена");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("В процессе выполнения программы произошла ошибка: " + e.getMessage());
        }
    }

    private void battle() {
        synchronized (battlingPlayers) {
            boss.takeDamage(battlingPlayers.size());

            if (isBattleOver())
                endBattle();
        }
    }

    public synchronized void joinBattle(Player player) {
        while (battlingPlayers.size() >= maxBattlingPlayers) {
            try {
                player.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (!boss.isDead()) {
            battlingPlayers.add(player);
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (!boss.isDead()) {
            deadPlayers.add(player);
            battlingPlayers.remove(player);
        }
    }

    private boolean isBattleOver() {
        boolean arePlayersAbsent = battlingPlayers.size() == 0 && boss.getHealth() > 0;

        return boss.isDead() || arePlayersAbsent;
    }

    private void endBattle() {
        addingPlayerTask.shutdownNow();
        battleTask.shutdownNow();
    }

    private void showBattleResult() {
        System.out.println("Сводка по сражению :");

        if (boss.isDead()) {
            System.out.println("Босс повержен. Победили игроки!");
        } else {
            System.out.println("Игроки повержены. Победил Босс!");
        }

        System.out.println();
        System.out.println("Сводка по игрокам : ");
        System.out.println("\nСлавные бойцы, погубившние боса : ");
        battlingPlayers.forEach(System.out::println);
        System.out.println("\nПавшие бойцы : ");
        deadPlayers.forEach(System.out::println);
        System.out.println("\nЖдуньки : ");
        players
            .stream()
            .filter(player -> !battlingPlayers.contains(player) && !deadPlayers.contains(player))
            .forEach(System.out::println);
    }
}
