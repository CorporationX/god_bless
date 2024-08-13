package faang.school.godbless.BJS2_21251;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
}
