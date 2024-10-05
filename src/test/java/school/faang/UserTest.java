package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    private String name;
    private int age;
    private String workingPlace;
    private String address;

    public static final int CONDITION_AGE = 18;

    @BeforeEach
    void setUp() {
        name = "Name 1";
        age = 18;
        workingPlace = "Amazon";
        address = "London";
    }

    @Test
    public void userCheckAgeCondition(){
        assertEquals(User.CHECK_AGE, CONDITION_AGE);
    }

    @Test
    public void userNormalCreationTest(){
        User user = new User(this.name, this.age, this.workingPlace, this.address);
        assertEquals(user.getName(), this.name);
        assertEquals(user.getAge(), this.age);
        assertEquals(user.getWorkingPlace(), this.workingPlace);
        assertEquals(user.getAddress(), this.address);
    }

    @Test
    public void userExceptionEmptyNameTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", this.age, this.workingPlace, this.address));
        assertEquals(exception.getMessage(), User.MESSAGE_ERROR_NAME);
    }

    @Test
    public void userExceptionEmptyAgeTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User(this.name, User.CHECK_AGE - 1, this.workingPlace, this.address));
        assertEquals(exception.getMessage(), User.MESSAGE_ERROR_AGE);
    }

    @Test
    public void userExceptionEmptyWorkingPlaceTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User(this.name, User.CHECK_AGE, null, this.address));
        assertEquals(exception.getMessage(), User.MESSAGE_ERROR_WORKING_PLACE);
    }

    @Test
    public void userExceptionEmptyAddressTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User(this.name, User.CHECK_AGE, this.workingPlace, null));
        assertEquals(exception.getMessage(), User.MESSAGE_ERROR_ADDRESS);
    }

    @Test
    public void userExceptionWrongWorkingPlaceTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User(this.name, User.CHECK_AGE, "Tesla", this.address));
        assertEquals(exception.getMessage(), User.MESSAGE_ERROR_WORKING_PLACE);
    }

    @Test
    public void userExceptionWrongAddressTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User(this.name, User.CHECK_AGE, this.workingPlace, "Berlin"));
        assertEquals(exception.getMessage(), User.MESSAGE_ERROR_ADDRESS);
    }
}