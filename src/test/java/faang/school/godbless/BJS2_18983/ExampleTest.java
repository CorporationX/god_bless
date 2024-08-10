package faang.school.godbless.BJS2_18983;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExampleTest {
    Example example;

    @BeforeEach
    void setUp() {
        example = new Example();
    }

    @Test
    void reverse() {
        int[] source = new int[]{1, 2, 3, 4, 5};
        int[] expected = new int[]{5, 4, 3, 2, 1};
        example.reverse(source);

        Assertions.assertThat(source).isEqualTo(expected);
    }
}