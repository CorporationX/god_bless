package faang.school.godbless.BJS2_12203;

import java.util.Random;

public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character , int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run(){
        String eats = getFoodType();
        System.out.println(getCharacter() + " give " + getFoodAmount() + " " + eats);
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(getCharacter() + " eating " + getFoodAmount() + " " + eats);
    }

    public String getCharacter() {
        return character;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
