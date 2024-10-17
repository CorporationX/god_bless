package school.faang.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private List<Food> foods = new ArrayList<>();
}
