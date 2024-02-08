package faang.school.godbless.hash_map.storage_amazon;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String category;

    @Override
    public String toString() {
        return "id: " + id + " name: " + name;
    }
}
