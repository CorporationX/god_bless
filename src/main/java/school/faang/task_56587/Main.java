package school.faang.task_56587;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        try {
            User goodUser = new User("Anna", 22, "Google", "London");
            System.out.println(goodUser);
        } catch (IllegalArgumentException e) {
            log.severe("Error creating user = " + e);
        }
    }
}
