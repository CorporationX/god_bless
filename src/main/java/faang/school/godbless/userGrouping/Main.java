package faang.school.godbless.userGrouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User testUser = User.builder()
                .name("Petr")
                .age(20)
                .jobCompany("Company One")
                .address("Address One")
                .build();

        User secondTestUser = User.builder()
                .name("Ivan")
                .age(29)
                .jobCompany("Company Two")
                .address("Address Two")
                .build();

        User thirdTestUser = User.builder()
                .name("Alex")
                .age(20)
                .jobCompany("Company Three")
                .address("Address Three")
                .build();

        Map<Integer, List<User>> integerListMap = User.groupUsers(Arrays.asList(testUser, secondTestUser, thirdTestUser));

        Set<Map.Entry<Integer, List<User>>> entries = integerListMap.entrySet();
        entries.forEach(System.out::println);
    }
}
