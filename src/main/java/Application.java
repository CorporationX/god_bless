package faang.school.godbless.model;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
        private String name;
        private int age;
        private String corporation;
        private String addres;
        public static  Map<Integer, List<User>> groupUsers(List<User> users); {
            return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
