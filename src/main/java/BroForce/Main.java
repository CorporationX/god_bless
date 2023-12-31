package BroForce;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        for (int i = 0; i < 10; i++) {
            game.players.add(new Player("Player" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(game.getPlayers().size() / 2);

        //ЦИКЛ для каждого потока -> пока все игроки живы - обновляем игру
        for (int i = 0; i < game.getPlayers().size() / 2; i++) {
            executorService.submit(() -> {
                while (game.isAllAlive()) {
                    game.update();
                }
            });
        }
        //Завешаем потоки, выводим результаты на экран
        executorService.shutdown();
        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Потеряно жизней " + game.getLives());
            System.out.println("Заработано очков " + game.getScore());
        }
    }
}
