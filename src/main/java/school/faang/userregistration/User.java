package school.faang.userregistration;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Getter
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(@NonNull String name, @NonNull int age, @NonNull String workplace, @NonNull String address) {

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
}
