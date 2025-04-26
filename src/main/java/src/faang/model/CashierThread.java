package src.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class CashierThread extends Thread {
    @Getter
    private final long id;
    private final CustomerProduct[] customerProducts;

    @Override
    public void run() {
        Arrays.stream(customerProducts)
                .forEach(customerProduct -> System.out.println(customerProduct.toString()));

        int priceAllProducts = Arrays.stream(customerProducts)
                .mapToInt(CustomerProduct::price)
                .sum();

        System.out.println("Products count" + customerProducts.length + ", price all products: " + priceAllProducts);
    }
}
