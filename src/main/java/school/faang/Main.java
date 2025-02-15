package school.faang;

public class Main {
    public static void main(String[] args) {
        // Проверка на то, что имя не должно быть пустым
        tryCreateUser("", 25, "Google", "London");

        // Проверка на то, что возраст должен быть больше 17
        tryCreateUser("Alex", 17, "Google", "London");

        // Проверка на то, что работа должна быть одной из возможных
        tryCreateUser("Alex", 18, "VKontakte", "London");

        // Проверка на то, что адрес должен быть одним из возможных
        tryCreateUser("Alex", 18, "Google", "Moscow");
    }

    private static void tryCreateUser(String name, int age, String job, String address) {
        try {
            new User(name, age, job, address);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
