package faang.school.godbless.BJS2_4122;

import faang.school.godbless.BJS2_4122.enums.Address;
import faang.school.godbless.BJS2_4122.enums.Job;
import faang.school.godbless.BJS2_4122.models.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Andrei", (byte) 22, Job.AMAZON, Address.AMSTERDAM),
                new User("Victor", (byte) 20, Job.UBER, Address.NEW_YORK),
                new User("Vlad", (byte) 21, Job.AMAZON, Address.LONDON),
                new User("Jack", (byte) 21, Job.GOOGLE, Address.NEW_YORK),
                new User("Nick", (byte) 23, Job.GOOGLE, Address.LONDON)
        );

        User Jack = new User("Jack", (byte) 21, Job.UBER, Address.AMSTERDAM);
        Jack.setJob(Job.AMAZON);
        Jack.setAge((byte) 18);
        Jack.setName("Andrei");
        Jack.setAddress(Address.LONDON);

        System.out.println(User.groupUsersByAge(users));
    }
}
