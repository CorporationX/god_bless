package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        Game game = new Game();
        Player player1 = new Player(game,"Vadim",5);
        Player player2 = new Player(game,"Beka",9);
        Player player3 = new Player(game,"Nurs",4);
        Player player4 = new Player(game,"Hadi",4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(player1);
        executorService.submit(player2);
        executorService.submit(player3);
        executorService.submit(player4);

        // Завершаем выполнение потоков
        executorService.shutdown();
    }
}