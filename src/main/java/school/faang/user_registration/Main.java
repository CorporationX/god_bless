package school.faang.user_registration;

public class Main {
    public static void main(String[] args) {
        User user = new User("", 17, "some job", "some address");
        User user1 = new User("Jack", 17, "some job", "some address");
        User user2 = new User("Jack", 18, "some job", "some address");
        User user3 = new User("Jack", 18, "Google", "some address");
        User user4 = new User("Jack", 18, "Google", "Big street");
    }
}
