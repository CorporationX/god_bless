package school.faang.module1.bjs2_80336;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;
}