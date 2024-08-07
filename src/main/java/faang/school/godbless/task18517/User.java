package faang.school.godbless.task18517;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class User {
    private String name;
    private Integer age;
    private String firm;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>();
    private static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
       VALID_JOBS.add("Google");
       VALID_JOBS.add("Uber");
       VALID_JOBS.add("Amazon");
    }

    static {
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, Integer age, String firm, String address) {
        if(name != null || name.matches("[a-zA-Z]+"))
            this.name = name;
        else
            throw new IllegalArgumentException("Отсутствует имя");

        if(age >= 18)
            this.age = age;
        else
            throw new IllegalArgumentException("Не верно указан возраст");

        if(VALID_JOBS.contains(firm))
            this.firm = firm;
        else
            throw new IllegalArgumentException("Данная фирма не найдена");

        if(VALID_ADDRESSES.contains(address))
            this.address = address;
        else
            throw new IllegalArgumentException("Данный адрес не найден");
    }
}
