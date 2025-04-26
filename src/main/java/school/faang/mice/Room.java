package school.faang.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private final int roomNumber;
    private final List<Food> foods = new ArrayList<>();

}

