package sprint3task9;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Character {
    private List<Item> inventory = new ArrayList<>();

}
