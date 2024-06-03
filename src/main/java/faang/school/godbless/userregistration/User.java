package faang.school.godbless.userregistration;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Arrays;

public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>((Arrays.asList("London", "New York", "Amsterdam")));


    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name != null && age > 18 && VALID_JOBS.contains(workplace) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Некорректное поле класса");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + ((name == null) ? 0 : name.hashCode()) + ((workplace == null) ? 0 : workplace.hashCode())
                + ((address==null ? 0 : address.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;
        return user.age == age
                && Objects.equals(name, user.name)
                && Objects.equals(workplace, user.workplace)
                && Objects.equals(address, user.address);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user: listUser) {
            int userAge = user.getAge();
            if (!mapUsers.containsKey(userAge)) {
                List<User> listUserToPut = new ArrayList<>();
                listUserToPut.add(user);
                mapUsers.put(userAge, listUserToPut);
            } else {
                mapUsers.get(userAge).add(user);
            }
        }

        return mapUsers;
    }

}
