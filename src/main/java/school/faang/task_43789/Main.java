package school.faang.task_43789;

public class Main {
    public static void main(String[] args) {
        User user = new User("John", 23, "Amazon", "London");
        System.out.println(user.getName() + " " + user.getAge()
                + " " + user.getJob() + " " + user.getAddress());
    }
}
