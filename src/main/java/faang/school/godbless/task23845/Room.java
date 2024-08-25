package faang.school.godbless.task23845;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public class Room {
    private List<Food> food = new ArrayList<>();
}
