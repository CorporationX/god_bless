package school.faang.bjs243679;

public class Main {
    public static void main(String[] args) {
        tryCreateUser("", 18, "Google", "Amsterdam");
        tryCreateUser("Pavel", 17, "Google", "Amsterdam");
        tryCreateUser("Pavel", 18, "Gooooooooogle", "Amsterdam");
        tryCreateUser("Pavel", 18, "Google", "Moscow");
        tryCreateUser("Pavel", 18, "Google", "Amsterdam");
    }

    private static void tryCreateUser(String name, int age, String job, String address) {
        try {
            new User(name, age, job, address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
