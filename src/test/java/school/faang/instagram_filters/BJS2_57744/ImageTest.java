package school.faang.instagram_filters.BJS2_57744;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    private Image luna;

    @BeforeEach
    void setUp() {
        luna = new Image("Luna", "The moon against the sky");
    }

    @Test
    void getName() {
        assertEquals("Luna", luna.getName());
    }

    @Test
    void getDescription() {
        assertEquals("The moon against the sky", luna.getDescription());
    }

    @Test
    void setDescription() {
        luna.setDescription("The moon in the reflection");
        assertEquals("The moon in the reflection", luna.getDescription());
    }
}