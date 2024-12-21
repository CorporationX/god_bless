package derschrank.sprint01.task05.bjstwo_43912;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> list = getListOfUsers();

        Map<Integer, List<User>> map = User.groupUsers(list);
        for (Integer age : map.keySet()) {
            System.out.println("age " + age + ": " + map.get(age));
        }

    }

    private static List<User> getListOfUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("John Smith", 18, "Tech Solutions Inc.", "123 Elm Street"));
        list.add(new User("Emily Johnson", 20, "Green Energy Co.", "45 Maple Avenue"));
        list.add(new User("Michael Brown", 19, "Blue Sky Logistics", "67 Oak Drive"));
        list.add(new User("Sarah Davis", 22, "Creative Studio Ltd.", "89 Pine Road"));
        list.add(new User("Christopher Wilson", 21, "Mountain View Farms", "101 Cedar Lane"));
        list.add(new User("Jessica Taylor", 19, "Digital Horizons LLC", "121 Birch Street"));
        list.add(new User("Daniel Martinez", 18, "Solar Power Corp.", "141 Willow Way"));
        list.add(new User("Emma Anderson", 22, "NextGen Robotics", "161 Cherry Boulevard"));
        list.add(new User("Matthew Thomas", 20, "HealthTech Partners", "181 Palm Court"));
        list.add(new User("Olivia Moore", 19, "NorthStar Media", "201 Fir Circle"));
        list.add(new User("Andrew Jackson", 21, "SmartHome Solutions", "221 Spruce Avenue"));
        list.add(new User("Sophia White", 18, "Rapid Transport Ltd.", "241 Ash Lane"));
        list.add(new User("Joshua Harris", 22, "EcoBuilding Materials", "261 Sycamore Drive"));
        list.add(new User("Isabella Martin", 20, "Urban Architects", "281 Linden Street"));
        list.add(new User("David Lee", 19, "Quantum Research Lab", "301 Poplar Boulevard"));
        list.add(new User("Mia Perez", 21, "Harmony Designs", "321 Holly Road"));
        list.add(new User("Alexander Clark", 18, "Global Trade Partners", "341 Cypress Street"));
        list.add(new User("Chloe Lewis", 22, "BrightFuture Education", "361 Magnolia Avenue"));
        list.add(new User("Ethan Hall", 19, "Apex Technologies", "381 Juniper Court"));
        list.add(new User("Sophia Walker", 21, "Velocity Dynamics", "401 Aspen Circle"));
        list.add(new User("Ryan Young", 18, "NextEra Industries", "421 Beech Way"));
        list.add(new User("Ava Allen", 20, "Fusion Healthcare", "441 Dogwood Boulevard"));
        list.add(new User("Jack King", 19, "EverGreen Solutions", "461 Redwood Lane"));
        list.add(new User("Lily Scott", 21, "Atlas Construction", "481 Alder Drive"));
        list.add(new User("Noah Adams", 22, "Infinity Aerospace", "501 Spruce Boulevard"));
        list.add(new User("Charlotte Hill", 18, "Nova Systems", "521 Maple Way"));
        list.add(new User("James Green", 20, "Dynamic Ventures", "541 Oak Street"));
        list.add(new User("Ella Rivera", 19, "Pioneer Technologies", "561 Elm Avenue"));
        list.add(new User("Lucas Baker", 21, "Heritage Finance", "581 Pine Court"));
        list.add(new User("Grace Gonzalez", 22, "Momentum Design", "601 Birch Circle"));

        return list;
    }
}
