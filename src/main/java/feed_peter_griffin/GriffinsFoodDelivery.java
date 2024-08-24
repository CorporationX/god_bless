package feed_peter_griffin;

import java.util.Random;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            Thread thread = new Thread(new FoodDeliveryTask(characterName, new Random().nextInt(1,10)));
            thread.start();
        }
    }
}
