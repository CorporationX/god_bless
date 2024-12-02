package school.faang.task_43670;

import lombok.Getter;

@Getter
public enum Address {
    London("London"),
    NewYork("New York"),
    Amsterdam("Amsterdam");
    private final String address;

    Address(String address) {
        this.address = address;
    }
}
