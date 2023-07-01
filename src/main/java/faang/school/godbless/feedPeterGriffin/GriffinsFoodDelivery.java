package faang.school.godbless.feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 потока создано
        for (String namesOfCharacter : characterNames) { // идем по именам
            executor.submit(new FoodDeliveryTask(namesOfCharacter, new Random().nextInt(50)));
            // каждему потоку присваиваем объект класса с рандомным именнем персонажа и рандомной едой
        }
        executor.shutdown(); // удаляем потоки
    }
}
