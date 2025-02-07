package school.faang.grouping_users_by_age.BJS2_56339.BJS2_56339;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alex", 20, "Office", "Rozembaum 2"),
                new User("Maria", 25, "School", "Green Street 15"),
                new User("John", 30, "Hospital", "Main Avenue 42"),
                new User("Anna", 22, "Cafe", "Broadway 7"),
                new User("Michael", 28, "Factory", "Industrial Zone 3"),
                new User("Sophia", 25, "University", "Campus Road 10"),
                new User("David", 30, "Bank", "Financial Square 1"),
                new User("Olivia", 25, "Library", "Book Lane 9"),
                new User("Daniel", 29, "Shop", "Market Street 12"),
                new User("Emma", 26, "Gym", "Fitness Blvd 5"),
                new User("James", 30, "Airport", "Skyline Drive 8"),
                new User("Lily", 22, "Hotel", "Tourist Road 6"),
                new User("William", 30, "Pharmacy", "Health Street 14"),
                new User("Grace", 20, "Restaurant", "Food Court 3"),
                new User("Benjamin", 32, "Warehouse", "Logistics Park 2"),
                new User("Chloe", 24, "Mall", "Shopping Plaza 7"),
                new User("Henry", 22, "Stadium", "Sports Avenue 11"),
                new User("Ella", 20, "Theater", "Art Lane 4"),
                new User("Samuel", 30, "Park", "Nature Path 16"),
                new User("Ava", 22, "Clinic", "Medical Center 22")
        );
        System.out.println(User.groupUsers(users));
    }
}

