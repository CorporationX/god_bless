package school.faang.BJS2_56482;

public class Main {
    public static void main(String[] args) {

        try {
            User andrey = new User("Andrey", 18, "Google", "London");
            System.out.println("Пользователь успешно сохранен!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации " + e.getMessage());
        }
    }
}