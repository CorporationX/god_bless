package school.faang.BJS235759;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        List<Knight> knightList = new ArrayList<>();
        knightList.add(new Knight("Knight 1", new ArrayList<>()));
        knightList.add(new Knight("Knight 2", new ArrayList<>()));

        String[] trialsKnight1 = {"Убийство дракона", "Перепей ближнего"};
        String[] trialsKnight2 = {"Отожмись 100 раз в латах", "Победи великана"};

        for (String trial : trialsKnight1) {
            knightList.get(0).addTrial(new Trial(knightList.get(0).getName(), trial));
        }

        for (String trial : trialsKnight2) {
            knightList.get(1).addTrial(new Trial(knightList.get(1).getName(), trial));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knightList.forEach(knight -> executorService.execute(knight::startTrials));
        executorService.shutdown();
    }
}
