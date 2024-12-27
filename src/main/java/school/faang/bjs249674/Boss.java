package school.faang.bjs249674;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final List<Player> players = Collections.synchronizedList(new ArrayList<>());
    private final ExecutorService executorService = Executors.newCachedThreadPool();


    public void joinBattle(Player player) {
        players.add(player);
        System.out.printf("%s Player %s has joined the battle on Thread: %s \n",
                LocalDateTime.now(), player.getName(), Thread.currentThread().getId());
        currentPlayers++;

        awaitAndLeaveBattle(player);
    }

    @SneakyThrows
    private void awaitAndLeaveBattle(Player player) {
        Random random = new Random();
        long playerBattleTime = (random.nextInt(1, 10) + 1) * 1000L;
        System.out.printf("%s Player %s battle time (ms.): %s on Thread: %s \n",
                LocalDateTime.now(), player.getName(), playerBattleTime, Thread.currentThread().getId());
        Thread.sleep(playerBattleTime);
        players.remove(player);
        currentPlayers--;
    }
}


