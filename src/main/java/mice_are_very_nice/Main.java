package mice_are_very_nice;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        Room room1 = new Room();
        room1.addFood(new Food("Cake"));
        room1.addFood(new Food("Apple"));

        Room room2 = new Room();
        room2.addFood(new Food("Cheese"));
        room2.addFood(new Food("Meet"));
        room2.addFood(new Food("Milk"));

        Room room3 = new Room();
        room3.addFood(new Food("Candies"));
        room3.addFood(new Food("Bread"));
        room3.addFood(new Food("Orange"));

        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);

        house.startFoodCollection();
    }
}
