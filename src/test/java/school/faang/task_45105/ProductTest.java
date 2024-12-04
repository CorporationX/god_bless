package school.faang.task_45105;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    @Test
    void testConstructorName() {
        String name = "Pork";
        String category = "Meat";

        Product result = new Product(name, category);

        assertEquals(name, result.getName());
    }

    @Test
    void testConstructorCategory() {
        String name = "Pork";
        String category = "Meat";

        Product first = new Product(name, category);

        assertEquals(category, first.getCategory());
    }

    @Test
    void testConstructorWithNullName() {
        String name = null;
        String category = "Meat";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(name, category));

        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testConstructorWithEmptyName() {
        String name = "";
        String category = "Meat";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(name, category));

        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testConstructorWithNullCategory() {
        String name = "name";
        String category = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(name, category));

        assertEquals("Category cannot be null or empty", exception.getMessage());
    }

    @Test
    void testConstructorWithEmptyCategory() {
        String name = "name";
        String category = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(name, category));

        assertEquals("Category cannot be null or empty", exception.getMessage());
    }
}