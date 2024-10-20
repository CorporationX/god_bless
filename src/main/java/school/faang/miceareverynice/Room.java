package school.faang.miceareverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private String roomName;
    private List<Food> foodList;

    @Override
    public String toString() {
        return roomName;
    }
}

