package miceAreVeryNice_36065;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private final String name;
    private List<Food> foods;
}
