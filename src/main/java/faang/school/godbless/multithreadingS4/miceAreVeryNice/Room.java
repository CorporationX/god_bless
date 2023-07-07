package faang.school.godbless.multithreadingS4.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;
}
