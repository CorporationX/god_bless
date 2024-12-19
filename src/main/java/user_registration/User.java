package user_registration;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE = 18;
    @NotBlank(message = "поле не может быть пустым")
    private String name;
    @NotNull(message = "поле не может быть пустым")
    @Min(value = 18, message = "вам не должно быть меньше 18 лет")
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = validateAge(age);
        this.job = validateValue(job, VALID_JOBS);
        this.address = validateValue(address, VALID_ADDRESSES);
    }

    public static String validateValue(String string, Set<String> stringList) {
        if (stringList.contains(string)) {
            return string;
        } else {
            throw new IllegalArgumentException(string + "' не содержится в списке!");
        }
    }

    public static int validateAge(int age) {
        if (age >= AGE) {
            return age;
        } else {
            throw new IllegalArgumentException("только совершеннолетние");
        }
    }
}
