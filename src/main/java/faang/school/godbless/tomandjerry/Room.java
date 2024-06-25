package faang.school.godbless.tomandjerry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private String name;
    private List<Food> food;
}
