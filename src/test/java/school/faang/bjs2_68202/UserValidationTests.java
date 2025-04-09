package school.faang.bjs2_68202;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static school.faang.bjs2_68202.User.VALID_ADDRESSES;
import static school.faang.bjs2_68202.User.VALID_JOBS;

@Slf4j
public class UserValidationTests {

    private static final String VALID_NAME = "Jonny";
    private static final Integer VALID_AGE = 18;
    private static final String VALID_JOB = VALID_JOBS.iterator().next();
    private static final String VALID_ADDRESS = VALID_ADDRESSES.iterator().next();

    private static final String INVALID_NAME_NULL = null;
    private static final String INVALID_NAME_EMPTY = "";
    private static final String INVALID_NAME_BLANK = "   ";
    private static final Integer INVALID_AGE = 17;
    private static final String INVALID_JOB = "Company";
    private static final String INVALID_ADDRESS = "City";

    // Name tests
    @Test
    public void nullNameUserThrowsIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new User(INVALID_NAME_NULL, VALID_AGE, VALID_JOB, VALID_ADDRESS))
                .as("null name user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void emptyNameUserThrowsIllegalArgumentException() {
        Assertions
                .assertThatThrownBy(() -> new User(INVALID_NAME_EMPTY, VALID_AGE, VALID_JOB, VALID_ADDRESS))
                .as("empty name user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void blankNameUserThrowsIllegalArgumentException() {
        Assertions
                .assertThatThrownBy(() -> new User(INVALID_NAME_BLANK, VALID_AGE, VALID_JOB, VALID_ADDRESS))
                .as("blank name user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Age test
    @Test
    public void invalidAgeUserThrowsIllegalArgumentException() {
        Assertions
                .assertThatThrownBy(() -> new User(VALID_NAME, INVALID_AGE, VALID_JOB, VALID_ADDRESS))
                .as("young user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Job test
    @Test
    public void invalidJobUserThrowsIllegalArgumentException() {
        Assertions
                .assertThatThrownBy(() -> new User(VALID_NAME, VALID_AGE, INVALID_JOB, VALID_ADDRESS))
                .as("invalid job user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Address test
    @Test
    public void invalidAddressUserThrowsIllegalArgumentException() {
        Assertions
                .assertThatThrownBy(() -> new User(VALID_NAME, VALID_AGE, VALID_JOB, INVALID_ADDRESS))
                .as("invalid address user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Full invalid
    @Test
    public void invalidUserThrowsIllegalArgumentException() {
        Assertions
                .assertThatThrownBy(() -> new User(INVALID_NAME_BLANK, INVALID_AGE, INVALID_JOB, INVALID_ADDRESS))
                .as(" all params invalid user should trow IllegalArgumentException")
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Valid user
    @Test
    public void validUserPassValidation() {
        User user = new User(VALID_NAME, VALID_AGE, VALID_JOB, VALID_ADDRESS);
        Assertions
                .assertThat(user.name())
                .as("user name not saved")
                .isEqualTo(VALID_NAME);
        Assertions
                .assertThat(user.age())
                .as("user age not saved")
                .isEqualTo(VALID_AGE);
        Assertions
                .assertThat(user.job())
                .as("user job not saved")
                .isEqualTo(VALID_JOB);
        Assertions
                .assertThat(user.address())
                .as("user address not saved")
                .isEqualTo(VALID_ADDRESS);
    }
}
