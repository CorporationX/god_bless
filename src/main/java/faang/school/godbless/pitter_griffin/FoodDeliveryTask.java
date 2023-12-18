package faang.school.godbless.pitter_griffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmound;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(getCharacter() + " получает " + getFoodAmound() + " " + food);
        try {
            Thread.sleep(new Random().nextInt(((6) + 1) * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getCharacter() + " ест " + getFoodAmound() + " " + food);
    }
}

class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < 3; i++) {
            executorService.submit(new FoodDeliveryTask(characterNames[i], new Random().nextInt(51) + 1));
        }
        executorService.shutdown();
    }
}