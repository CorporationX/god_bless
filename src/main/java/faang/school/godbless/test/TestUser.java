package faang.school.godbless.test;


import faang.school.godbless.groupusers.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestUser {

    private User alex = new User("Alex", 27, "Google", "bla bla bla street");
    private User alex1 = new User("Alex1", 27, "Google1", "bla bla bla street");
    private User alex2 = new User("Alex2", 27, "Google2", "bla bla bla street");
    private User alex3 = new User("Alex3", 27, "Google3", "bla bla bla street");
    private User tom = new User("Tom", 18, "Amazon", "bla bla bla street");
    private User tom1 = new User("Tom1", 18, "Amazon", "bla bla bla street");
    private User tom2 = new User("Tom2", 18, "Amazon", "bla bla bla street");
    private User tom3 = new User("Tom3", 18, "Amazon", "bla bla bla street");
    private User mikel = new User("Mikel", 20, "Lenovo", "bla bla bla street");
    private User mikel1 = new User("Mikel", 20, "Lenovo", "bla bla bla street");
    private User mikel2 = new User("Mikel", 20, "Lenovo", "bla bla bla street");
    private User mikel3 = new User("Mikel", 20, "Lenovo", "bla bla bla street");


    private final List<User> usersList = new ArrayList<>(
            List.of(alex, alex1, alex2, alex3, tom, tom1, tom2, tom3, mikel, mikel1, mikel2, mikel3));

    private final Map<Integer, List<User>> expected = new HashMap<>(
            Map.of(
                    27, new ArrayList<>(List.of(alex, alex1, alex2, alex3)),
                    18, new ArrayList<>(List.of(tom, tom1, tom2, tom3)),
                    20, new ArrayList<>(List.of(mikel, mikel1, mikel2, mikel3))
            )
    );

    public static void main(String[] args) {
        new TestUser().shouldReturnMapGroupedByAge();
    }

    public void shouldReturnMapGroupedByAge() {
        List<User> list = new ArrayList<>(
                List.of(alex, alex1, alex2, alex3, tom, tom1, tom2, tom3, mikel, mikel1, mikel2, mikel3));

        Map<Integer, List<User>> actual = User.groupUsers(list);
        System.out.println(expected);
        System.out.println(actual);

        assert expected.equals(actual);
    }
}
