package amazonWarehouse;

import lombok.Value;

@Value
public class Product {
    private int id;
    private String name;
    private String category;
}
