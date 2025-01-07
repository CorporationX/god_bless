package school.faang.sprint_4.task_51094;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Getter
public class Order {
    private static final String DISCOUNT_ALREADY_APPLIED_EXCEPTION_MESSAGE = "Discount has already been applied";
    private static final String DISCOUNT_OUT_OF_RANGE_EXCEPTION_MESSAGE = "Discount should be between 0 and 100";

    private final List<Product> products;

    private BigDecimal totalPrice;
    private boolean discountApplied;

    public Order(List<Product> products) {
        this.products = List.copyOf(products);
        totalPrice = getPrice();
    }

    public void applyDiscount(int discount) throws OrderException {
        if (discountApplied) {
            throw new OrderException(DISCOUNT_ALREADY_APPLIED_EXCEPTION_MESSAGE);
        }
        if (discount < 0 || discount > 100) {
            throw new OrderException(DISCOUNT_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
        totalPrice = getPrice()
                .multiply(BigDecimal.valueOf(1 - discount / 100f))
                .setScale(0, RoundingMode.HALF_UP);
        discountApplied = true;
    }

    public BigDecimal getPrice() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return discountApplied == order.discountApplied
                && Objects.equals(products, order.products)
                && Objects.equals(totalPrice, order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice, discountApplied);
    }
}