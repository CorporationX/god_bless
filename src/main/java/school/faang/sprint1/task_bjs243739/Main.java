package school.faang.sprint1.task_bjs243739;

public class Main {
    public static void main(String[] args) {
        createUser("Masha", 25, "Uber", "Amsterdam");
        createUser("Sasha", 12, "Google", "London");
        createUser("Denis", 40, "WrongGoogle", "Saint-Petersburg");
        createUser("Vera", 37, "Google", "Saint-Petersburg");
    }

    private static void createUser(String name, Integer age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println(user);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
