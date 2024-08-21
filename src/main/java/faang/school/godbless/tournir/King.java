package faang.school.godbless.tournir;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private ExecutorService service;
    private List<Knight> knights;

    public static void main(String[] args) {
        King king = new King();

        king.knights = List.of(
                new Knight("1"),
                new Knight("2"),
                new Knight("3"),
                new Knight("4"),
                new Knight("5"),
                new Knight("6"),
                new Knight("7"),
                new Knight("8")
        );
        for (int i = 0; i < king.knights.size(); i++) {
            king.knights.get(i).addTrial(new Trial(king.knights.get(i).getName(), Integer.toString(i+1)));
            king.knights.get(i).addTrial(new Trial(king.knights.get(i).getName(), i+1 + Integer.toString(i+1)));
        }

        king.service = Executors.newFixedThreadPool(2);

        king.startTrials();

        king.service.shutdown();
    }

    public void startTrials() {
        for (Knight knight : knights) {//каждый рыцарь начинает выполнять испытания в отдельном потоке
            service.submit(knight);
        }
    }
}
