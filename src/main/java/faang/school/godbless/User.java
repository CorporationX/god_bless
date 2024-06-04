package faang.school.godbless;
import java.util.Set;


public class User {
    private String username;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String username, int age, String job, String address) {

        boolean haveError = false;

        if (username == null || username.isEmpty()) {
            haveError = true;
        }

        if (age < 18) {
            haveError = true;
        }

        if (!VALID_JOBS.contains(job)){
            haveError = true;
        }

        if (!VALID_ADDRESSES.contains(address)){
            haveError = true;
        }

        if (haveError){
            throw new IllegalArgumentException("Не прошел тест");
        }

        this.username = username;
        this.age = age;
        this.job = job;
        this.address = address;

    }


    @Override
    public String toString(){
        return "Пользователь{" +
                "имя='" + username + '\'' +
                ", возраст=" + age +
                ", работа='" + job + '\'' +
                ", адрес='" + address + '\'' +
                '}';
    }



}

