package school.faang.userRegistration;

public class Main {
    public static void main(String[] args) {
        testValidUser();
        testInvalidJob();
        testInvalidAddress();
        testUnderageUser();
    }

    // Тест с корректными данными
    private static void testValidUser() {
        try {
            User user = new User("Alice", 25, "Google", "London");
            System.out.println("testValidUser PASSED: " + user.getName());
        } catch (Exception e) {
            System.err.println("testValidUser FAILED: " + e.getMessage());
        }
    }

    // Тест с некорректным значением job
    private static void testInvalidJob() {
        try {
            // "Facebook" не входит в список VALID_JOBS
            User user = new User("Bob", 30, "Facebook", "New York");
            System.err.println("testInvalidJob FAILED: исключение не было выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("testInvalidJob PASSED: " + e.getMessage());
        }
    }

    // Тест с некорректным значением address
    private static void testInvalidAddress() {
        try {
            // "Paris" не входит в список VALID_ADDRESSES
            User user = new User("Charlie", 22, "Uber", "Paris");
            System.err.println("testInvalidAddress FAILED: исключение не было выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("testInvalidAddress PASSED: " + e.getMessage());
        }
    }

    // Тест с пользователем младше 18 лет
    private static void testUnderageUser() {
        try {
            User user = new User("Dave", 17, "Amazon", "Amsterdam");
            System.err.println("testUnderageUser FAILED: исключение не выбрашено, @Min не проверяется автоматически.");
        } catch (IllegalArgumentException e) {
            System.out.println("testUnderageUser PASSED: " + e.getMessage());
        }
    }
}