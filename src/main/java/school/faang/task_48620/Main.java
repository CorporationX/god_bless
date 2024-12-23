package school.faang.task_48620;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room("Кухня");
        Room livingRoom = new Room("Гостиная");
        Room bedroom = new Room("Спальня");

        kitchen.addFood(new Food("Яблоко"));
        kitchen.addFood(new Food("Груша"));

        livingRoom.addFood(new Food("Печенье"));
        livingRoom.addFood(new Food("Молоко"));

        bedroom.addFood(new Food("Бутерброд"));
        bedroom.addFood(new Food("Сок"));

        house.addRoom(kitchen);
        house.addRoom(livingRoom);
        house.addRoom(bedroom);

        house.startCollectingFood();
    }
}