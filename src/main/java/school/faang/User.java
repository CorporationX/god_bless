package school.faang;

import lombok.Data;

import java.util.*;


@Data
public class User {
    final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String adress;

    public User(String name, int age, String job, String address) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (getVALID_JOBS().contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Invalid job");
        }

        if (getVALID_ADDRESSES().contains(adress)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    public static Map<Integer, List<User>> groupUsers (List<User> UsersList){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (int i = 0; i < UsersList.size(); i++) {
            List<User> TempList = new ArrayList<>();

            for (int j = 0; j < UsersList.size(); j++) {
                if (Objects.equals(UsersList.get(i).getAge(), UsersList.get(j).getAge())){
                    TempList.add(UsersList.get(j));
                    groupedUsers.put(UsersList.get(i).getAge(), TempList);
                }
            }
        }
        return groupedUsers;
    }

}
