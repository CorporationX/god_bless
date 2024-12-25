package school.faang.sprint3.task48562miceverynice;

import java.util.*;

public class House {
    private static List<Room> rooms = new ArrayList<>();
    private Set<Food> collectFoods = new HashSet<>();


    public void collectFood() {
        int randomRoom1 = (int) (Math.random() * (rooms.size() - 1));
        int randomRoom2 = randomRoom1;
        while (randomRoom1 == randomRoom2) {
            randomRoom2 = (int) (Math.random() * (rooms.size() - 1));
        }
        collectFoods.addAll(rooms.get(randomRoom1).getFoods());
        collectFoods.addAll(rooms.get(randomRoom2).getFoods());

        rooms.get(randomRoom1).getFoods().clear();
        rooms.get(randomRoom2).getFoods().clear();
    }

    public static void main(String[] args) {
        House house = new House() {{
            rooms.addAll(Arrays.asList(new Room() {{
                getFoods().add(new Food("Apple"));
                getFoods().add(new Food("Banana"));
                getFoods().add(new Food("Bread"));
                getFoods().add(new Food("Cheese"));
            }}, new Room() {{
                getFoods().add(new Food("Cheese"));
                getFoods().add(new Food("Milk"));
                getFoods().add(new Food("Bread"));
            }}, new Room() {{
                getFoods().add(new Food("Apple"));
                getFoods().add(new Food("Milk"));
                getFoods().add(new Food("Bread"));
            }}, new Room() {{
                getFoods().add(new Food("Apple"));
                getFoods().add(new Food("Banana"));
            }}, new Room() {{
                getFoods().add(new Food("Banana"));
                getFoods().add(new Food("Bread"));
            }}));
        }};

    }
}
