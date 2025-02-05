package school.faang.BJS2_56482;

public class Main {
    public static void main(String[] args) {
        User andrey = new User("Andrey", 17, "Google", "London");

        try {
            andrey.validInformation();
            System.out.println("Пользователь успешно сохранен!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации " + e.getMessage());
        }
    }
}
