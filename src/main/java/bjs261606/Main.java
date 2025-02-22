package bjs261606;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 6);
        List<Player> players = List.of(
                new Player("First player", 100, Position.BEGINNER, 0, 20),
                new Player("Second player", 100, Position.BEGINNER, 0, 20),
                new Player("Third player", 100, Position.BEGINNER, 0, 20),
                new Player("Fourth player", 100, Position.BEGINNER, 0, 20),
                new Player("Fifth player", 100, Position.BEGINNER, 0, 20),
                new Player("Sixth player", 100, Position.BEGINNER, 0, 20));

        List<Thread> threadsList = getThreads(players, game);
        threadsList.forEach(Thread::start);
        threadsList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static List<Thread> getThreads(List<Player> players, Game game) {
        List<Thread> threadsList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                int currentIndex = i;
                int previousIndex = currentIndex - 1;
                Thread thread = new Thread(() -> {
                    game.update(players.get(currentIndex), players.get(previousIndex));
                    game.update(players.get(currentIndex), players.get(previousIndex));
                    game.update(players.get(currentIndex), players.get(previousIndex));
                });
                threadsList.add(thread);
            }
        }
        return threadsList;
    }
}
