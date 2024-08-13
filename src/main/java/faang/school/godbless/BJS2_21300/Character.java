package faang.school.godbless.BJS2_21300;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private List<Item> itemsList = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
