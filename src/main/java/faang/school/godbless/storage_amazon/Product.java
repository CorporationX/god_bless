package faang.school.godbless.storage_amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    @Override
    public String toString() {
        return "id: " + id + " name: " + name;
    }
}
