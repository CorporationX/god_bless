package school.faang.sprint_1.task_bjs2n43703;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Tom", 19, "Google", "Amsterdam");
            System.out.println(user);

            User user2 = new User("Alex", 25, "Google", "Amsterdam");
            System.out.println(user2);
            user2.setAddress("Palm Avenue");
            System.out.println(user2);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
