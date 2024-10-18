package school.faangSprint3.t04;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i < 5; i++) {
            Room room = new Room();
            for (int j = 0; j < 3; j++) {
                room.addFood(new Food("Еда " + (i * 3 + j + 1)));
            }
            house.addRoom(room);
        }

        house.startFoodCollection(5);
    }
}