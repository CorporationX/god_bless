package LordOfRings;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Character {
    List<Item> inventory = new ArrayList<>();
}
