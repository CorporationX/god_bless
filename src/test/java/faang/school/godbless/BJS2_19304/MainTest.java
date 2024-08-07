package faang.school.godbless.BJS2_19304;

import org.junit.jupiter.api.Test;

class MainTest {

    Main main = new Main();

    {
        main.getProducts().add(new Product(1, "Playstation 4", "Console"));
        main.getProducts().add(new Product(2, "Xbox 360", "Console"));
        main.getProducts().add(new Product(3, "Playstation 5", "Console"));
        main.getProducts().add(new Product(4, "Samsung", "TV"));
        main.getProducts().add(new Product(5, "LG", "TV"));
        main.getProducts().add(new Product(6, "Sony", "TV"));
        main.getProducts().add(new Product(7, "Toyota", "Car"));
        main.getProducts().add(new Product(8, "Honda", "Car"));
        main.getProducts().add(new Product(9, "Subaru", "Car"));
    }

    @Test
    void printProducts() {
        main.printProducts();
    }
}