package school.faang.sprint_4.task_51073;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Order {
    private final List<Product> products;

    public void applyDiscount(double discount) {
        double totalPrice = getTotalPrice();
        totalPrice -= totalPrice * (discount / 100);
        System.out.println("Total price with discount: " + totalPrice);
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
