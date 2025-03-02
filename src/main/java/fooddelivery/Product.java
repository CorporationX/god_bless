package fooddelivery;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Product {
    private final String name;
    private final double price;
}
