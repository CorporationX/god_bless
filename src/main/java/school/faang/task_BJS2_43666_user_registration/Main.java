package school.faang.task_BJS2_43666_user_registration;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("TestUser1", 20, "Google", "London");
        System.out.println(user1);
        try {
            new User("", 20, "Google", "London");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            new User("TestUser3", 10, "Google", "London");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            new User("TestUser4", 20, "Galera", "London");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            new User("TestUser5", 20, "Google", "Zimbabwe");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
