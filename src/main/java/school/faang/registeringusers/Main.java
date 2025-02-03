package school.faang.registeringusers;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Maxim", 26, "Google", "New York");

            System.out.printf("Name: %s, age: %d, job: %s, address: %s",
                    validUser.getName(), validUser.getAge(), validUser.getJob(), validUser.getAddress());
        } catch (Exception error) {
            System.out.print(error.getMessage());
        }
    }
}
