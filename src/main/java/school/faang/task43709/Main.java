package school.faang.task43709;

public class Main {
    public static void main(String[] args) {
        User user = new User("Павел", 20, "Google", "London");

        System.out.println("Имя пользователя: " + user.getName());
        System.out.println("Возраст пользователя: " + user.getAge());
        System.out.println("Место работы пользователя: " + user.getJob());
        System.out.println("Адрес пользователя: " + user.getAddress());
    }
}
