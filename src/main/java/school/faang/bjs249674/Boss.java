package school.faang.bjs249674;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final List<Player> players = Collections.synchronizedList(new ArrayList<>());
    private final ExecutorService executorService = Executors.newCachedThreadPool();


    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (players.size() >= maxPlayers) {
            System.out.println("Max amount of players exceeded, waiting for free slot");
            this.wait();
        }
        players.add(player);
        System.out.printf("Player %s has joined the battle\n", player.getName());
        currentPlayers++;
        this.notify();

        awaitAndLeaveBattle(player);
    }

    @SneakyThrows
    private void awaitAndLeaveBattle(Player player) {
        Random random = new Random();
        Thread.sleep((random.nextInt(1, 10)+1)* 1000L);
        synchronized (this) {
            players.remove(player);
            currentPlayers--;
            this.notify();
        }
    }
}


