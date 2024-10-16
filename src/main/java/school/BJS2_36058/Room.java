package school.BJS2_36058;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class Room {
    @Getter
    private String name;
    private List<Food> foods = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public void getFoods(List<Food> collectedFoods, House house) {
        synchronized (foods) {
            if (this.hasFood()) {
                foods.forEach(x -> collectedFoods.add(x));
                foods.clear();
                house.getLatch().countDown();
                System.out.printf("Еда собрана из комнаты: " + name);
                System.out.println();
            } else {
                System.out.println("Не найдено еды в комнате: " + name);
            }
        }
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
