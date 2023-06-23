package user_registration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsersValidatorTest {
    @Test
    public void validateUser_shouldReturnExceptionWithName(){
        assertThrows(IllegalArgumentException.class, () -> new UsersValidator(" ",19,"Google","London"));
        assertThrows(IllegalArgumentException.class, () -> new UsersValidator(null,19,"Google","London"));
    }

    @Test
    public void validateUser_shouldReturnExceptionWithAge(){
        assertThrows(IllegalArgumentException.class, () -> new UsersValidator("Max",17,"Google","London"));
    }
    @Test
    public void validatorUser_shouldReturnExceptionWithAddress(){
        assertThrows(IllegalArgumentException.class, () -> new UsersValidator("Max",19,"Google","Isa"));
    }
    @Test
    public void validator_shouldReturnExceptionWithPlaceOfWork(){
        assertThrows(IllegalArgumentException.class, () -> new UsersValidator("Max",19,"Yandex","London"));
    }

}
