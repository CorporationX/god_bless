package school.faang.sprint_1.task_43752;

public class Main {
    public static void main(String[] args) {
        checkUsersData("Ilya", 18, "Google", "London");
        checkUsersData("Kevin", 17, "Uber", "New York");
        checkUsersData("Ilya", 34, "Amazon", "Amsterdam");
        checkUsersData("", 22, "Google", "London");

    }

    private static void checkUsersData(String name, Integer age, String job, String address) {
        try {
            new User(name, age, job, address);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
