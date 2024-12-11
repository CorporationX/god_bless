package school.faang.sprint_1.task_43793;

public class Main {
    public static void main(String[] args) {
        User john = new User("", 16, "Alfa Bank", "Paris");
        User bob = new User("Bob", 20, "Facebook", "London");
        User Vlad = new User("Vlad", 20, "Uber", "Amsterdam");
        Vlad.setAddress("Paris");
        Vlad.setAddress("London");
        Vlad.setName("Vladislav");
        Vlad.setJob("Amazon");
        Vlad.setAge(25);
    }
}
