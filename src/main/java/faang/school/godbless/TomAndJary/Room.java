package faang.school.godbless.TomAndJary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@Getter
public class Room {
    private String name;
    private List<Food> foods;


}
