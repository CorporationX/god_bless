package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        User user1 = buildUser("1", "", 20, "Google", "London");
        if (user1 != null) { System.out.println(user1); }

        User user2 = buildUser("2", "Tom", 17, "Google", "London");
        if (user2 != null) { System.out.println(user2); }

        User user3 = buildUser("3", "Sam", 40, "Facebook", "Amsterdam");
        if (user3 != null) { System.out.println(user3); }

        User user4 = buildUser("4", "Tim", 40, "Uber", "Paris");
        if (user4 != null) { System.out.println(user4); }

        User user5 = buildUser("5", "Tim", 40, "Uber", "Amsterdam");
        if (user5 != null) { System.out.println(user5); }
    }

    private static User buildUser(String id, String name, int age, String job, String address) {
        try {
            return new User(id, name, age, job, address);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}