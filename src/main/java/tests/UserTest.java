package tests;

import faang.school.godbless.classes.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    private List<User> listAllUsers;
    private List<User> users20Age;
    private List<User> users21Age;
    private List<User> users23Age;
    private List<User> users25Age;

    @BeforeEach
    public void setUp() {
        User rustam = new User("Rustam", 21, "Nizhnevartovsk", "ul. Mira");
        User ruby = new User("Ruuby", 20, "Nizhnevartovsk", "ul. Mira");
        User andrew = new User("Andrew", 21, "Nizhnevartovsk", "ul. Lenina");
        User vlad = new User("Vlad", 25, "Amsterdam, Uber", "Amsterdam");
        User nikolay = new User("Nikolay", 25, "Novosibirsk, Yandex", "Novosibirsk");
        User sveta = new User("Sveta", 23, "Tinkoff", "Dont know(");
        User petya = new User("Petya", 23, "GAS", "Surgut");

        listAllUsers.add(rustam);
        listAllUsers.add(ruby);
        listAllUsers.add(andrew);
        listAllUsers.add(vlad);
        listAllUsers.add(nikolay);
        listAllUsers.add(sveta);
        listAllUsers.add(petya);

        users20Age.add(ruby);

        users21Age.add(rustam);
        users21Age.add(andrew);

        users23Age.add(sveta);
        users23Age.add(petya);

        users25Age.add(vlad);
        users25Age.add(nikolay);
    }

    @Test
    public void testListToMap() {
        Map<Integer, List<User>> expected = new HashMap<>();
        expected.put(20, users20Age);
        expected.put(21, users21Age);
        expected.put(23, users23Age);
        expected.put(25, users25Age);

        Map<Integer, List<User>> testMap = User.groupUser(listAllUsers);
    }

}
