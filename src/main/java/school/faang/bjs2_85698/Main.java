package school.faang.bjs2_85698;

import java.util.Set;

public class Main {
    public static void main(String [] args) {
        Set<User> users = Set.of(
                new User("Roman", 18, "OpenAI", "Almaty"),
                new User("Vlad", 24, "Uber", "Amsterdam"),
                new User("Andrew", 12, "Amazon", "London"),
                new User("Alisa", 99, "Google", "New York")
                );
    }
}
