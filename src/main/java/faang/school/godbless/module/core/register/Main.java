package faang.school.godbless.module.core.register;

public class Main {
    public static void main(String[] args) {
        User ivan = null;
        try {
            ivan = new User("Иван", 20, "Google", "London");;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка валидации создания пользователя", e);
        }
        System.out.println(ivan);
    }
}
