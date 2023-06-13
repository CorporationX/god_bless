package Task2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
    public class User {
        private String name;
        private int age;
        private String placeOfWork;
        private String address;
        private static final Set<String> VALID_JOBS = Set.of("Google","Uber","Amazon");
        private static final Set<String> VALID_ADDRESSES = Set.of("London","New York","Amsterdam");
        private static final int EIGHTEEN = 18;

        public User(String name, int age, String placeOfWork, String address) {
            if (name == null || age < EIGHTEEN || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)){
                throw new IllegalArgumentException();
            }
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }

        public static Map<Integer, List<User>> groupUsers(List<User> usersList){
            Map<Integer, List<User>> groupsUsers = new HashMap<>();
            for (User user : usersList) {
                int age = user.getAge();
                groupsUsers.putIfAbsent(age, new ArrayList<>());
                groupsUsers.get(age).add(user);
            }

            return groupsUsers;

        }

}
