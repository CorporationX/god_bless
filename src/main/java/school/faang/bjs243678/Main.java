package school.faang.bjs243678;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>() {
            {
                add(new User("", 19, "Workplace0", "Address0"));
                add(new User("Name1", 19, "Workplace1", "Address1"));
                add(new User("Name2", 18, "uBEr", "london"));
                add(new User("Name3", 19, "Amazon", "Address3"));
                add(new User("Name4", 39, "Workplace4", "New york"));
                add(new User("Name5", 16, "Google", "Amsterdam"));
            }
        };
    }
}
