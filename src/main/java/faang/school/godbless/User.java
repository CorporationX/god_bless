package faang.school.godbless;


import java.util.Arrays;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int NUMBER_CONSTANT = 18;

    public User(String name, int age, String workPlace, String address) {
        if (!name.isEmpty() & age > NUMBER_CONSTANT & VALID_JOBS.contains(workPlace) & VALID_ADDRESSES.contains(address)){
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }else throw new IllegalArgumentException();

//        try {
//            if (!name.isEmpty())
//                this.name = name;
//            if (age > 18) {
//                this.age = age;
//            }
//            if (VALID_JOBS.contains(workPlace)) {
//                this.workPlace = workPlace;
//            }
//            if (VALID_ADDRESSES.contains(address)) {
//                this.address = address;
//            }
//        } catch (Exception e) {
//            System.out.println("Ошшибка ввода данных");
//            e.printStackTrace();
//        }


//        if (name.isEmpty()) {
//            throw new IllegalArgumentException("sdsd");
//        } else
//            this.name = name;
//        if (age < 18) {
//            throw new IllegalArgumentException("sdsd");
//        } else this.age = age;
//        if (!VALID_JOBS.contains(workPlace)) {
//            throw new IllegalArgumentException("sdsd");
//        }else this.workPlace = workPlace;
//        if (!VALID_ADDRESSES.contains(address)) {
//            throw new IllegalArgumentException("sdsd");
//        } else this.address = address;


    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
