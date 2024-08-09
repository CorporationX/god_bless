package faang.school.godbless.dolbahlop;

import java.util.Set;

public class User {
    private static final Set<String> VALID_WORKPLACE = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address){
        validateName(name);
        validateAge(age);
        validateWorkplace(workplace);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name can't be empty or null, you'd better check it");
        }
    }

    private void validateAge(int age){
        if (age < 18){
            throw new IllegalArgumentException("You must be 18 or older");
        }
    }

    private void validateWorkplace(String workplace){
        if (!VALID_WORKPLACE.contains(workplace)){
            throw new IllegalArgumentException("Invalid workplace: " + workplace);
        }
    }

    private void validateAddress(String address){
        if (!VALID_ADDRESS.contains(address)){
            throw new IllegalArgumentException("Invalid address: " + address);
        }
    }
}
