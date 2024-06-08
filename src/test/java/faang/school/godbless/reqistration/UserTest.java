package faang.school.godbless.reqistration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import faang.school.godbless.registration.User;
import org.junit.jupiter.api.Test;

class UserTest {

    private static final int USER_AGE_18 = 18;

    @Test
    void throwIllegalArgumentExceptionIfMinorAge() {
        final Integer userAgeMinor = 10;
        assertAll(() -> {
            var exception = assertThrows(IllegalArgumentException.class, () -> getUser("user1", userAgeMinor));
            assertThat(exception.getMessage()).isEqualTo("Error: age is less than 18");
        });
    }

    @Test
    void throwIllegalArgumentExceptionIfNullName() {
        assertAll(() -> {
            var exception = assertThrows(IllegalArgumentException.class, () -> getUser(null, USER_AGE_18));
            assertThat(exception.getMessage()).isEqualTo("Error: name is null or empty");
        });
    }

    @Test
    void throwIllegalArgumentExceptionIfEmptyName() {
        assertAll(() -> {
            var exception = assertThrows(IllegalArgumentException.class, () -> getUser("", USER_AGE_18));
            assertThat(exception.getMessage()).isEqualTo("Error: name is null or empty");
        });
    }

    @Test
    void throwIllegalArgumentExceptionIfNotContainJob() {
        assertAll(() -> {
            var exception = assertThrows(IllegalArgumentException.class, () -> new User("user1", USER_AGE_18, "fakeJob", "London"));
            assertThat(exception.getMessage()).isEqualTo("Error: job is not valid");
        });
    }

    @Test
    void throwIllegalArgumentExceptionIfNotContainAddress() {
        assertAll(() -> {
            var exception = assertThrows(IllegalArgumentException.class, () -> new User("user1", USER_AGE_18, "Google", "fakeAddress"));
            assertThat(exception.getMessage()).isEqualTo("Error: address is not valid");
        });
    }

    private static User getUser(String name, Integer age) {
        return new User(name, age, "Google", "London");
    }
}
