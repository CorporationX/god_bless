package faang.school.godbless.BJS2_18435;

public class Main {
    private static void createUser(String name, int age, String workPlace, String address) {
        try {
            User user = new User(name, age, workPlace, address);
            System.out.println("User " + user.name() + " created successfully");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createUser("Alice", 30, "Google", "London");
        createUser("", 25, "Google", "London");
        createUser("Dave", 17, "Google", "London");
        createUser("Eve", 25, "UnknownCompany", "London");
        createUser("Frank", 25, "Google", "UnknownCity");
    }
}
