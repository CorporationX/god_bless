package Sprint_4_Supercow;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                System.out.println(Thread.currentThread().getName() + " я добавился");
            } else {
                try {
                    System.out.println(Thread.currentThread().getName() + " я жду");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(Thread.currentThread().getName() + " ушел из батла");
            lock.notifyAll();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {

        Boss boss = new Boss(4);
        Thread player1Thread = new Thread(() -> boss.joinBattle(new Player("Player 1")));
        Thread player2Thread = new Thread(() -> boss.joinBattle(new Player("Player 2")));
        Thread player3Thread = new Thread(() -> {
            boss.joinBattle(new Player("Player 3"));
            boss.leaveBattle(new Player("Player 3"));
        });
        Thread player4Thread = new Thread(() -> {
            boss.joinBattle(new Player("Player 4"));
            boss.leaveBattle(new Player("Player 4"));
        });
        Thread player5Thread = new Thread(() -> {
            boss.joinBattle(new Player("Player 5"));
            boss.leaveBattle(new Player("Player 5"));
        });
        Thread player6Thread = new Thread(() -> boss.joinBattle(new Player("Player 6")));

        player1Thread.start();
        player2Thread.start();
        player3Thread.start();
        player4Thread.start();
        player5Thread.start();
        player6Thread.start();

        player1Thread.join();
        player2Thread.join();
        player3Thread.join();
        player4Thread.join();
        player5Thread.join();
        player6Thread.join();
    }
}
