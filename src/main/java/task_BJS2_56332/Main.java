package task_BJS2_56332;

public class Main {
    public static void main(String[] args) {
        User correctUser = new User("Anton", 20, "Google", "New York");
        System.out.println(correctUser);

        try {
            new User(" ", 18, "Uber", "Amsterdam");
        } catch (IllegalArgumentException nameException) {
            System.out.println(nameException);
        }

        try {
            new User("Anton", 17, "Uber", "Amsterdam");
        } catch (IllegalArgumentException ageException) {
            System.out.println(ageException);
        }

        try {
            new User("Anton", 18, "Sber", "Amsterdam");
        } catch (IllegalArgumentException jobPlaceException) {
            System.out.println(jobPlaceException);
        }

        try {
            new User("Anton", 18, "Uber", "Moscow");
        } catch (IllegalArgumentException jobAddressException) {
            System.out.println(jobAddressException);
        }
    }
}
