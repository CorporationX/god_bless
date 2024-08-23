package faang.school.godbless.Griffin;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : characterNames) {
            System.out.println("Start delivery for " + name);
            Thread thread = new Thread(new FoodDeliveryTask(name, 3));
            thread.start();
        }
    }
}
