package faang.school.godbless.Kate.BJS2_7540_7844;

public class App {
    public static void main(String[] args) {
        User user01 = new User("Alice", 25, "Uber", "London");
        User user02 = new User("Piter", 25, "Google", "NY");
        User user03 = new User("Chris", 30, "Google", "Amsterdam");
        User user04 = new User("Ben", 27, "Amazon", "Amsterdam");
        //User user05 = new User("", 25, "Amazon", "Amsterdam");
        //User user06 = new User("Greg", 15, "Amazon", "Amsterdam");
        //User user07 = new User("Ann", 28, "Amazon", "Moscow");
        //User user08 = new User("Ann", 28, "Ozon", "Moscow");
        System.out.println(User.users.toString());
        System.out.println(User.groupUsers(User.users).toString());
       //
    }
}
