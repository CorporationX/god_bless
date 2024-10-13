package school.BJS2_36058;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {

    private String name;
    private List<Food> foods = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
