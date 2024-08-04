package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        try {
            User user1 = new User("1", "", 20, "Google", "London");
//            User user2 = new User("2", "Tom", 17, "Google", "London");
//            User user3 = new User("3", "Sam", 40, "Facebook", "Amsterdam");
//            User user4 = new User("4", "Tim", 40, "Uber", "Paris");
//            User user5 = new User("5", "Tim", 40, "Uber", "Amsterdam");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}