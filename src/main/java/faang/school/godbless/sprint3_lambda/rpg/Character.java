package faang.school.godbless.sprint3_lambda.rpg;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Character {
    List<Item> inventory;

    public Character() {
        inventory = new ArrayList<>();
    }
}
