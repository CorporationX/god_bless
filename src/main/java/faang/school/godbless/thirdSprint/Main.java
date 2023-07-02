package faang.school.godbless.thirdSprint;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Room bedroom = new Room("bedroom");
        bedroom.addFood(new Food("apple"));
        bedroom.addFood(new Food("orange"));
        bedroom.addFood(new Food("chocolate"));
        bedroom.addFood(new Food("cheese"));

        Room livingRoom = new Room("living room");
        livingRoom.addFood(new Food("kiwi"));
        livingRoom.addFood(new Food("juice"));
        livingRoom.addFood(new Food("milk"));

        Room bathRoom = new Room("bath room");
        bathRoom.addFood(new Food("cucumber"));
        bathRoom.addFood(new Food("avocado"));

        Room kitchen = new Room("kitchen");
        livingRoom.addFood(new Food("pizza"));
        livingRoom.addFood(new Food("burger"));
        livingRoom.addFood(new Food("cola"));

        House house = new House(List.of(bedroom, livingRoom, bathRoom, kitchen));
        house.startFoodCollection();
    }
}
