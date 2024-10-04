package dima.evseenko.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Category category;

    public enum Category {
        PC, NOTEBOOK, PHONE, TV
    }
}
