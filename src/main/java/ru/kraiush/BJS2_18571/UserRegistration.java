package ru.kraiush.BJS2_18571;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRegistration {

    String name;
    String job;
    String address;

    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public UserRegistration(String name, String job, String address) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User's name cannot be blank or null");
        }

        if (VALID_JOBS.contains(job) || VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.job = job;
            this.address = address;
        } else
            throw new IllegalArgumentException("parametres <job> or <address> do not masch!");
    }
}
