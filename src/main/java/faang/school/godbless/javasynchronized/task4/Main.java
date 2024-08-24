package faang.school.godbless.javasynchronized.task4;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bro bro1 = new Bro("Xiaohua Hoang", 5);
        Bro bro2 = new Bro("Yuliya Jackson", 6);
        Bro bro3 = new Bro("Jianming Abbas", 4);
        Bro bro4 = new Bro("Gita Aziz", 8);
        Bro bro5 = new Bro("Radha Nguyen", 10);
        List<Bro> bros = List.of(bro1, bro2, bro3, bro4, bro5);
        game.addBros(bros);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        bros.forEach(bro -> executorService.execute(() -> {
            while (game.getBros().size() > 1) {
                game.update();
            }
        }));
        executorService.shutdown();
    }
}
