package school.faang.registration;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Ira", 18, "Google", "Amsterdam");

        try {
            //User user2 = new User("", 17, "Google", "Amsterdam");
            //User user3 = new User("Ira", 19, "Google", "Amsterdam");
            //User user4 = new User("Ira", 18, "Jira", "Amsterdam");
            User user5 = new User("Ira", 18, "Google", "Tokio");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
