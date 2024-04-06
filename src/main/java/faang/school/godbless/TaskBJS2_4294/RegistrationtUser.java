package faang.school.godbless.TaskBJS2_4294;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@ToString(onlyExplicitlyIncluded = true)
public class RegistrationtUser {
    protected final static String[] VILD_JOBS = new String[]{"Google", "Uber", "Amazon"};
    protected final static String[] VALID_ADDRESS = new String[]{"London", "New York", "Amsterdam"};
    @ToString.Include
    private String name;
    @ToString.Include
    private int age;
    @ToString.Include
    private String job;
    @ToString.Include
    private String address;

    List<String> list_jobs = Arrays.asList(VILD_JOBS);
    List<String> list_address = Arrays.asList(VALID_ADDRESS);

    public RegistrationtUser(String name, int age, String job, String address) {
        if (name == null || age < 18 || !list_jobs.contains(job) || !list_address.contains(address))
            throw new IllegalArgumentException("Проверьте формат полей");
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
