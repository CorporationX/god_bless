package school.faang.bjs2_69976;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//NoArgs добавлен исключительно чтобы не забывать навешивать его на сущности Hibernate
@NoArgsConstructor
public class Item {
    private String name;
    private int price;
}
