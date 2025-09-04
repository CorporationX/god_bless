package school.faang;

import school.faang.BJS2_85750.User;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Name1", 25, "Apple", "San Francisko");
            System.out.println(user1);
        } catch (Exception e) {
            System.out.println("create user1 error: " + e);
        }
        try {
            User user2 = new User("Name2", 26, "Tesla", "New York");
            System.out.println(user2);
        } catch (Exception e) {
            System.out.println("create user2 error: " + e);
        }
        try {
            User user3 = new User("Name3", 27, "Google", "London");
            System.out.println(user3);
        } catch (Exception e) {
            System.out.println("create user3 error: " + e);
        }
        try {
            User user4 = new User("Name4", 28, "Amazon", "Chicago");
            System.out.println(user4);
        } catch (Exception e) {
            System.out.println("create user4 error: " + e);
        }
        try {
            User user5 = new User("Name5", 29, "Uber", "Paris");
            System.out.println(user5);
        } catch (Exception e) {
            System.out.println("create user4 error: " + e);
        }
        try {
            User user6 = new User("Name6", 17, "Uber", "Paris");
            System.out.println(user6);
        } catch (Exception e) {
            System.out.println("create user6 error: " + e);
        }
        try {
            User user7 = new User(null, 29, "Uber", "Paris");
            System.out.println(user7);
        } catch (Exception e) {
            System.out.println("create user7 error: " + e);
        }
    }
}
