package faang.school.godbless.user_registration;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    @ParameterizedTest
    @MethodSource("initUserProvider")
    void throwIllegalArgumentException(String name, int age, String company, String address) {
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, company, address));
    }

    private Stream<Arguments> initUserProvider() {
        return Stream.of(
                Arguments.of("", 18, "Google", "New York"),
                Arguments.of("Vitaliy", 16, "Amazon", "Amsterdam"),
                Arguments.of("Sam", 20, "Bad company", "London"),
                Arguments.of("Elena", 24, "Uber", "Moscow")
                );
    }
}