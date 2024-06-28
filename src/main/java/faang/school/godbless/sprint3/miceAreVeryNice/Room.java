package faang.school.godbless.sprint3.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class Room {

    private List<Food> foods;
}
