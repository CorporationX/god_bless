package faang.school.godbless.BJS2_11814;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {
    private List<Room> rooms;
    private List<Food> foods;

    public void collectFood(){

    }

    public static void main(String[] args) {
        House house = new House();

        Room dinningRoom = new Room("Dining room");
        Room kitchenRoom = new Room("Kitchen room");
        Room bedRoom = new Room("Bed room");
        Room livingRoom = new Room("living room");
        Room attic = new Room("Attic");

        Food pasta = new Food("Pasta");
        Food frenchFry = new Food("French Fry");
        Food pizza = new Food("pizza");
        Food pie = new Food("Pie");
        Food cake = new Food("Cake");
        Food beefSteak = new Food("beefSteak");
        Food fish = new Food("Fish");

        house.addRooms(dinningRoom,kitchenRoom,bedRoom,livingRoom,attic);
        house.addFood(pasta,frenchFry,pizza,pie,cake,beefSteak,fish);

    }

    public void addRooms(Room ... room) {
        if(rooms == null) {
            rooms = new ArrayList<>();
        }
        rooms.addAll(Arrays.asList(room));
    }

    public void addFood (Food ... food) {
        if(foods == null) {
            foods = new ArrayList<>();
        }
        foods.addAll(Arrays.asList(food));
    }

}
