package school.faang.task43894;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("John Smith", 30, "ABC Corp", "New York, NY, 1st Ave, Apt 101"),
                new User("Maria Johnson", 25, "XYZ Ltd", "Los Angeles, CA, Sunset Blvd, Apt 202"),
                new User("Michael Brown", 40, "Freelance", "Chicago, IL, Michigan Ave, Apt 303"),
                new User("Anna Davis", 28, "Tech Solutions", "Houston, TX, Main St, Apt 404"),
                new User("David Wilson", 25, "Creative Agency", "Phoenix, AZ, Camelback Rd, Apt 505"),
                new User("Emma Garcia", 32, "Marketing Group", "Philadelphia, PA, Walnut St, Apt 606"),
                new User("James Martinez", 45, "Consulting Firm", "San Antonio, TX, Broadway St, Apt 707"),
                new User("Olivia Rodriguez", 24, "Design Studio", "San Diego, CA, Pacific Hwy, Apt 808"),
                new User("Daniel Lee", 38, "Construction Co.", "Dallas, TX, Elm St, Apt 909"),
                new User("Sophia Walker", 26, "Finance Inc.", "San Jose, CA, Santa Clara St, Apt 1001"),
                new User("William Hall", 18, "Real Estate Agency", "Austin, TX, Congress Ave, Apt 1102"),
                new User("Isabella Young", 31, "Healthcare Services", "Jacksonville, FL, Beach Blvd, Apt 1203"),
                new User("Benjamin Hernandez", 18, "IT Solutions", "San Francisco, CA, Market St, Apt 1304"),
                new User("Mia King", 24, "E-commerce Co.", "Columbus, OH, High St, Apt 1405"),
                new User("Lucas Wright", 25, "Logistics Co.", "Fort Worth, TX, Lancaster Ave, Apt 1506"
                ));

        var group = User.groupUsers(users);

        for (var userMap : group.entrySet()) {
            System.out.println("Age: " + userMap.getKey() + " List: " + userMap.getValue());
        }
    }
}
