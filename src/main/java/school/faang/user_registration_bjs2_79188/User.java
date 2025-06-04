package school.faang.user_registration_bjs2_79188;

import lombok.ToString;

import java.util.Set;

@ToString(includeFieldNames = true)
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    User(String name, int age, String job, String address) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name cant be null");
        }
        if (age < 18) {
            throw new IllegalArgumentException("age cant be less than 18");
        }
        if (!VALID_JOBS.contains(job.toLowerCase())) {
            throw new IllegalArgumentException("job not valid");
        }
        if (!VALID_ADDRESSES.contains(address.toLowerCase())) {
            throw new IllegalArgumentException("address not valid");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static final Set<String> VALID_JOBS = Set.of("google", "uber", "amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("london", "new york", "amsterdam");
}
