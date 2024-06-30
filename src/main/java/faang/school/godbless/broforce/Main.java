package faang.school.godbless.broforce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(5,5);
        List<Integer> pl1 = List.of(1,2,3,4,5,6);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Thread threadOne = new Thread(()->{
            try {
                game.update();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadTwo = new Thread(()->{
            try {
                game.update();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        pl1.forEach(elem-> {
            service.submit(threadOne::start);
            service.submit(threadTwo::start);
        });
        threadOne.join();
        threadTwo.join();
    }
}
