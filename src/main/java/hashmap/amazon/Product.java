package hashmap.amazon;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final String category;
}
