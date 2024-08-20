package BJS2_23820_MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class Room {
    private final String roomName;
    private final List<Food> foodList;
}
