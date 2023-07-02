package faang.school.godbless;

import java.util.List;

public class Room {
    private List<Food> food;

    public Room(List<Food> food){
        this.food = food;
    }

    public List<Food> getFood(){
        return food;
    }
}
