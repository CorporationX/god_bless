package school.faang.task_56472;

public class Main {
    public static void main(String[] args) {
        User validUserFields = new User("Jack", 18, "Uber", "New York");
        System.out.println(validUserFields);

        User invalidUserName = new User(" ", 18, "Uber", "New York");
        User invalidUserAge = new User("Jack", 16, "Uber", "New York");
        User invalidUserJob = new User("Jack", 18, "Yandex", "New York");
        User invalidUserAddress = new User("Jack", 18, "Uber", "Moscow");
    }
}
