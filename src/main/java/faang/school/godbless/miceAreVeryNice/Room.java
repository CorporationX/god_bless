package faang.school.godbless.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> foods = new ArrayList<>();
}
