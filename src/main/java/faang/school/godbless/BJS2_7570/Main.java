package faang.school.godbless.BJS2_7570;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Vasya", 18, "WorkAddressVasya", "AddressVasya"));
        users.add(new User("Petya", 18, "WorkAddressPetya", "AddressPetya"));
        users.add(new User("Slava", 17, "WorkAddressSlava", "AddressSlava"));
        users.add(new User("Masha", 17, "WorkAddressMasha", "AddressMasha"));
        users.add(new User("Katya", 17, "WorkAddressKatya", "AddressKatya"));
        users.add(new User("Inna", 19, "WorkAddressInna", "AddressInna"));
        users.add(new User("Gosha", 19, "WorkAddressGosha", "AddressGosha"));
        User.groupUsers(users).entrySet().forEach(System.out::println);

    }
}
