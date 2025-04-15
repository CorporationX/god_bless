package school.faang.bjs2_69976;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
//NoArgs добавлен исключительно чтобы не забывать навешивать его на сущности Hibernate
@NoArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;
}
