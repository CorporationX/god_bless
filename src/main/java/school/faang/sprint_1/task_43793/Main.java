package school.faang.sprint_1.task_43793;

public class Main {
    public static void main(String[] args) {
        User john = new User("", 16, "Alfa Bank", "Paris");
        User bob = new User("Bob", 20, "Facebook", "London");
        User vlad = new User("vlad", 20, "Uber", "Amsterdam");
        vlad.setAddress("Paris");
        vlad.setAddress("London");
        vlad.setName("Vladislav");
        vlad.setJob("Amazon");
        vlad.setAge(25);
    }
}
