package faang.school.godbless.miceAndNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private String name;
    private List<Food> food;
}
