package school.faang.bjs245552;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor()
@Getter
public class Character {
    @NonNull
    private final String id;
    private final List<Item> inventory;


    public Character(String id) {
        this.id = id;
        this.inventory = new ArrayList<>();
    }

}
