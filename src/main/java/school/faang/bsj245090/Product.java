package school.faang.bsj245090;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String category;

    Set<Product> products = new HashSet<>();
}
