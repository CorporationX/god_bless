package school.faang.validation;

public class Main {

    public static void main(String[] args) {
        testValidUser("Данила", 36, "Google", "London");
        testValidUser("Александр", 37, "Amazon", "New York");
        testValidUser("Алексей", 35, "Uber", "Amsterdam");

        testInvalidUser("Алекс", 37, "New York", "New York", "Недопустимое место работы");
        testInvalidUser("Егор", 36, "Amazon", "Amazon", "Недопустимый адрес");
        testInvalidUser("Света", 17, "Google", "London", "Возраст не может быть меньше 18");
        testInvalidUser("", 37, "Google", "London", "Имя не может быть пустым");
        testInvalidUser(null, 25, "Uber", "Amsterdam", "Имя не может быть пустым");
    }

    private static void testValidUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.printf("Успешно создан пользователь: %s, %d, %s, %s\n",
                    user.getName(), user.getAge(), user.getJob(), user.getAddress());
        } catch (Exception e) {
            System.err.printf("ВНИМАНИЕ! Неожиданная ошибка при создании пользователя %s, %d, %s, %s: %s\n",
                    name, age, job, address, e.getMessage());
        }
    }

    private static void testInvalidUser(String name, int age, String job, String address, String expectedError) {
        try {
            new User(name, age, job, address);
            System.err.printf("ВНИМАНИЕ! Пользователь %s, %d, %s, %s был создан, но должен был вызвать ошибку '%s'\n",
                    name, age, job, address, expectedError);
        } catch (IllegalArgumentException e) {
            System.out.printf("Правильно отклонен невалидный пользователь %s, %d, %s, %s: %s\n",
                    name, age, job, address, e.getMessage());
        }
    }
}
