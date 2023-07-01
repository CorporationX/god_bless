import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight fisrtKnight = new Knight("Артур");
        Knight secondKnight = new Knight("Ахилес");
        fisrtKnight.addTrial(new Trial(fisrtKnight.getName(), "Дракон"));
        fisrtKnight.addTrial(new Trial(fisrtKnight.getName(), "Медуза Гаргона"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Циклоп"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Минотавр"));
        fisrtKnight.startTrials();
        secondKnight.startTrials();
    }
}
