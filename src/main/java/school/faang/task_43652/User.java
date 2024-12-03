package school.faang.task_43652;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class User {

    private String name;
    private int age;
    private String job;
    private String address;


    public void setName(String name) {
        if (name == null && name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!AllowedJob.ALLOWED_JOB.contains(job)) {
            throw new IllegalArgumentException("Wrong job place");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!AllowedAddress.ALLOWED_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Wrong address");
        }
        this.address = address;
    }
}
