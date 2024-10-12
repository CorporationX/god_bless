package RPG;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private List<Item> inventory = new ArrayList<>();
}
