package faang.school.godbless.instaFilter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    @Test
    void shouldThrowException(){
        assertThrowsExactly(IllegalArgumentException.class, ()-> new Image("", ""));
        assertThrowsExactly(IllegalArgumentException.class, ()-> new Image(null, ""));
    }

    @Test
    void testCreateImage(){
        assertDoesNotThrow(()->new Image("image", null));
    }

}