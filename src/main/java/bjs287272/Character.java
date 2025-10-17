package bjs287272;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> inventory;
}
