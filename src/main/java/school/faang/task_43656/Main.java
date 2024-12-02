package school.faang.task_43656;

public class Main {
    public static void main(String[] args) {
        User goodUser = createUser("Maxim", 20, "Google", "New York");
        printUser(goodUser);
        User emptyNameUser = createUser("", 20, "Google", "New York");
        printUser(emptyNameUser);
        User invalidAgeUser = createUser("Nikolay", 17, "Google", "New York");
        printUser(invalidAgeUser);
        User invalidJobUser = createUser("Nina", 27, "Taxi", "New York");
        printUser(invalidJobUser);
        User invalideAddrUser = createUser("Misha", 37, "Amazon", "Riga");
        printUser(invalideAddrUser);
    }

    public static User createUser(String name, int age, String job, String address) {
        User user;
        try {
            user = new User(name, age, job, address);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return user;
    }

    public static void printUser(User user) {
        if (user != null) {
            System.out.println("User was created:");
            System.out.println(user);
        }
    }
}
