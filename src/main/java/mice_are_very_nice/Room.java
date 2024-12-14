package mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private final List<Food> food;
}
