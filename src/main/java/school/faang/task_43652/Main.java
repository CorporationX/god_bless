package school.faang.task_43652;

public class Main {

    public static void main(String[] args) {

        User myUser = new User();

        myUser.setName("Anatolijs");
        myUser.setAge(18);
        myUser.setJob("Uber");
        myUser.setAddress("London");

        System.out.println(myUser);
        System.out.println(myUser.getName());
    }
}
