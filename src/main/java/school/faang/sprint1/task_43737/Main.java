package school.faang.sprint1.task_43737;

public class Main {
    public static void main(String[] args) {
        printUser("Anna", 23, "Amazon", "Amsterdam"); //all data are valid
        printUser("Katia", 15, "Google", "New York"); //age is not valid
        printUser("Vasia", 24, "Tesla", "London"); // job is not valid
        printUser("Dima", 25, "Uber", "Chicago"); // address is not valid
    }

    public static void printUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
