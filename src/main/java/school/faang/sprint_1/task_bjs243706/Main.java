package school.faang.sprint_1.task_bjs243706;

public class Main {
    public static void main(String[] args) {
        User validUser = new User("Mike", 18, "Google", "London");

        var userWithIncorrectAge = User.createIncorrectUser("Mike", 17, "Google", "London");
        var userWithIncorrectJob = User.createIncorrectUser("Mike", 18, "Yandex", "London");
        var userWithIncorrectAddress = User.createIncorrectUser("Mike", 18, "Google", "Moscow");

        System.out.println(validUser);
    }
}
