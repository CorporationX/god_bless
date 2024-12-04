package school.faang.task_43696;

public class Main {
    public static void main(String[] args) {
        printResult("User1", 18, "Google", "London");
        printResult("User2", 19, "Amazon", "Amsterdam");
        printResult("User3", 20, "Uber", "New York");

        printResult("User4", 17, "Google", "New York");
        printResult("User5", 18, "", "New York");
        printResult("User5", 19, "Amazon", "");
    }

    private static void printResult(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
