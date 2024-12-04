package school.faang.task43709;

public class Main {
    public static void main(String[] args) {
        User user = new User("Владимир", 18, "Google", "London");
        printUsers(user);
    }

    public static void printUsers(User users){
        System.out.println("Имя пользователя: " + users.getName());
        System.out.println("Возраст пользователя: " + users.getAge());
        System.out.println("Место работы пользователя: " + users.getJob());
        System.out.println("Адрес пользователя: " + users.getAddress());
    }
}
