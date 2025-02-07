import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_56460.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    //PositiveTest

    @Test
    @DisplayName("Все значения правильные")
    public void testUserConstructor_rightParams() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = "Uber";
        String address = "London";
        //assert
        assertDoesNotThrow(() -> new User(name, age, job, address));
    }

    //NegativeTest

    //TestName

    @Test
    @DisplayName("Пустое значение в имени")
    public void testUserConstructor_EmptyName() {
        //arrange
        String name = "";
        int age = 21;
        String job = "Uber";
        String address = "Amsterdam";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    @Test
    @DisplayName("Null значение в имени")
    public void testUserConstructor_NullName() {
        //arrange
        String name = null;
        int age = 21;
        String job = "Uber";
        String address = "Amsterdam";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    //TestAge

    @Test
    @DisplayName("Некоректное значение в возврасте")
    public void testUserConstructor_WrongAge() {
        //arrange
        String name = "Joe";
        int age = 16;
        String job = "Uber";
        String address = "Amsterdam";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    //TestJob

    @Test
    @DisplayName("Пустое значение в работе")
    public void testUserConstructor_EmptyJob() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = "";
        String address = "Amsterdam";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    @Test
    @DisplayName("Null значение в работе")
    public void testUserConstructor_NullJob() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = null;
        String address = "Amsterdam";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    @Test
    @DisplayName("Некоректное значение в работе")
    public void testUserConstructor_WrongJob() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = "Alfa";
        String address = "Amsterdam";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    //TestAddress

    @Test
    @DisplayName("Пустое значение в адресе")
    public void testUserConstructor_EmptyAddress() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = "Uber";
        String address = "";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    @Test
    @DisplayName("Null значение в адресе")
    public void testUserConstructor_NullAddress() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = "Uber";
        String address = null;
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }

    @Test
    @DisplayName("Некоректное значение в адресе")
    public void testUserConstructor_WrongAddress() {
        //arrange
        String name = "Joe";
        int age = 21;
        String job = "Uber";
        String address = "Msk";
        //assert
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
    }
}
