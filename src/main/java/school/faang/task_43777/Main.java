package school.faang.task_43777;

public class Main {
    public static void main(String[] args) {
        UserFactory.createUsers().forEach(System.out::println);
    }
}