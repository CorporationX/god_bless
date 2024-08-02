package faang.school.godbless.userRegistration;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Nested
    class PositiveTests {
        @Test
        public void testCreateCorrectUser() {
            User correctUser = TestData.getCorrectUser();

            assertNotNull(correctUser);
            assertEquals("David", correctUser.getName());
            assertEquals(28, correctUser.getAge());
            assertEquals("Uber", correctUser.getJob());
            assertEquals("Amsterdam", correctUser.getAddress());
        }
    }


    @Nested
    class NegativeTests {
        @Test
        public void testCreateUserWithInvalidName() {
            Exception exception = assertThrows(IllegalArgumentException.class, TestData::getUserWithInvalidName);

            assertEquals("Name can't be empty", exception.getMessage());
        }

        @Test
        public void testCreateUserWithInvalidAge() {
            Exception exception = assertThrows(IllegalArgumentException.class, TestData::getUserWithInvalidAge);

            assertEquals("Age can't be lower 18", exception.getMessage());
        }

        @Test
        public void testCreateUserWithInvalidJob() {
            Exception exception = assertThrows(IllegalArgumentException.class, TestData::getUserWithInvalidJob);

            assertEquals("Invalid job. Must contain valid jobs", exception.getMessage());
        }

        @Test
        public void testCreateUserWithInvalidAddress() {
            Exception exception = assertThrows(IllegalArgumentException.class, TestData::getUserWithInvalidAddress);

            assertEquals("Invalid address. Must contain valid addresses", exception.getMessage());
        }
    }


    @Nested
    class TestData {
        private static User getCorrectUser() {
            return User.builder()
                    .name("David")
                    .age(28)
                    .job("Uber")
                    .address("Amsterdam")
                    .build();
        }

        private static void getUserWithInvalidName() {
            User.builder()
                    .name("")
                    .age(27)
                    .job("Google")
                    .address("London")
                    .build();
        }

        private static void getUserWithInvalidJob() {
            User.builder()
                    .name("John")
                    .age(30)
                    .job("Barista")
                    .address("New York")
                    .build();
        }

        private static void getUserWithInvalidAge() {
            User.builder()
                    .name("Anna")
                    .age(8)
                    .job("Uber")
                    .address("New York")
                    .build();
        }

        private static void getUserWithInvalidAddress() {
            User.builder()
                    .name("Maria")
                    .age(22)
                    .job("Amazon")
                    .address("Rome")
                    .build();
        }
    }
}




