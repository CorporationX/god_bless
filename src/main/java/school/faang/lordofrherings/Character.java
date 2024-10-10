package school.faang.lordofrherings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private List<Item> inventory = new ArrayList<>();
    private String character;

    public Character(String character) {
        this.character = character;
    }
}
