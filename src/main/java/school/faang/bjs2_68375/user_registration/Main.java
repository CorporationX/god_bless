package school.faang.bjs2_68375.user_registration;

public class Main {
    public static void main(String[] args) {
        processUserCreationException(1, "Vasilii", 18, "Google", "London");
        processUserCreationException(2, "", 18, "Google", "London");
        processUserCreationException(3, null, 18, "Google", "London");
        processUserCreationException(4, "Vasilii", 5, "Google", "London");
        processUserCreationException(5, "Vasilii", 22, "AMD", "London");
        processUserCreationException(6, "Vasilii", 22, "Google", "Moscow");
        processUserCreationException(7, "Vasilii", 22, null, "Moscow");
        processUserCreationException(8, "Vasilii", 22, "Google", null);
        processUserCreationException(9, null, 0, null, null);
        processUserCreationException(10, "Petr", 22, "Uber", "Amsterdam");
    }

    private static void processUserCreationException(int index, String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println("user " + index + " is added: " + user);
        } catch (IllegalArgumentException e) {
            System.out.println("user " + index + " has not valid data: " + e.getMessage());
        }
    }
}
