package src.faang.model;

public record Customer(CustomerProduct[] getCustomerProducts) {
    public CustomerProduct[] getCustomerProducts() {
        return getCustomerProducts.clone();
    }
}
