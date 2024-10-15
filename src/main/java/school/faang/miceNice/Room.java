package school.faang.miceNice;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private final  String name;
    private final List<Food> foodList;
}
