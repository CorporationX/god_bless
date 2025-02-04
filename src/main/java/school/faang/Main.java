package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Alex", 20, "Office", "Rozembaum 2"));
        users.add(new User("Maria", 25, "School", "Green Street 15"));
        users.add(new User("John", 30, "Hospital", "Main Avenue 42"));
        users.add(new User("Anna", 22, "Cafe", "Broadway 7"));
        users.add(new User("Michael", 28, "Factory", "Industrial Zone 3"));
        users.add(new User("Sophia", 25, "University", "Campus Road 10"));
        users.add(new User("David", 30, "Bank", "Financial Square 1"));
        users.add(new User("Olivia", 25, "Library", "Book Lane 9"));
        users.add(new User("Daniel", 29, "Shop", "Market Street 12"));
        users.add(new User("Emma", 26, "Gym", "Fitness Blvd 5"));
        users.add(new User("James", 30, "Airport", "Skyline Drive 8"));
        users.add(new User("Lily", 22, "Hotel", "Tourist Road 6"));
        users.add(new User("William", 30, "Pharmacy", "Health Street 14"));
        users.add(new User("Grace", 20, "Restaurant", "Food Court 3"));
        users.add(new User("Benjamin", 32, "Warehouse", "Logistics Park 2"));
        users.add(new User("Chloe", 24, "Mall", "Shopping Plaza 7"));
        users.add(new User("Henry", 22, "Stadium", "Sports Avenue 11"));
        users.add(new User("Ella", 20, "Theater", "Art Lane 4"));
        users.add(new User("Samuel", 30, "Park", "Nature Path 16"));
        users.add(new User("Ava", 22, "Clinic", "Medical Center 22"));

        System.out.println(User.groupUsers(users));

    }
}

