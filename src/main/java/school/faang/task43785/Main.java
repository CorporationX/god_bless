package school.faang.task43785;

import school.faang.task43785.model.User;

public class Main {
    public static void main(String[] args) {

        try {
            User user = new User("Gustav", 22, "Uber", "London");
            System.out.println("User created: " + user);

        } catch (RuntimeException e) {
            System.out.println("Error creating user: \n" + e.getMessage());
        }


    }
}
