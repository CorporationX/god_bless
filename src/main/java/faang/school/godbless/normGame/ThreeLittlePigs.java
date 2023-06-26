package faang.school.godbless.normGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Pig1Thread pig1 = new Pig1Thread("Ниф-Ниф", "Солома");
        Pig1Thread pig2 = new Pig1Thread("Нуф-Нуф", "Палки");
        Pig1Thread pig3 = new Pig1Thread("Наф-Наф", "Кирпичи");
        List<PigThread> pigs = List.of(pig1, pig2, pig3);

        for (int i = 0; i < 3; i++) {
            service.submit(pigs.get(i));
        }
        service.shutdown();
        try {
            if(service.awaitTermination(10, TimeUnit.MILLISECONDS))
                System.out.println("Игра завершена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
