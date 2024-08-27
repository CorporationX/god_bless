package faang.school.godbless.fi.ringslord;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Character {

    private final String name;
    private final List<Item> inventory = new ArrayList<>();

}
