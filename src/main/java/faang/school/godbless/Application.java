package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        User user = new User("AAA", 23, "Uber", "London");
        System.out.println(user);
        User user1 = new User("AAA", 10, "Uber", "London");
        System.out.println(user1);
        User user2 = new User("", 10, "Uber", "London");
        System.out.println(user2);
        User user3 = new User(" ", 10, "Uber", "London");
        System.out.println(user3);
    }
}
