package school.faang.bjs243678;

import lombok.Getter;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import static school.faang.bjs243678.Constants.VALID_JOBS;
import static school.faang.bjs243678.Constants.VALID_ADDRESSES;

public class User {

    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }

        if (age < 18) {
            System.out.println("Age cannot be less than 18");
            return;
        }

        if (!VALID_JOBS.contains(workplace.toLowerCase())) {
            StringJoiner joiner = new StringJoiner(" ,");
            VALID_JOBS.forEach(item -> joiner.add(item));
            System.out.println("Workplace entered: " + workplace + ", but should be one of the following values: "
                    + joiner);
            return;
        }

        if (!VALID_ADDRESSES.contains(address.toLowerCase())) {
            System.out.printf("Address entered: %s, but should be one of the following values: %s%n",
                    address, String.join(" ,", VALID_JOBS));
            return;
        }

        //  if (!VALID_ADDRESSES.contains(address.toLowerCase())) {
        //      System.out.printf("Address entered: %s, but should be one of the following values: %s%n",
        //          address, VALID_ADDRESSES.stream().collect(Collectors.joining(" ,")));
        //      return;
        //  }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

}