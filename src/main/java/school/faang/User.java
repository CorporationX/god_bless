package school.faang;

import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Data
public class User {
    public static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    public static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};
    public static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    /**
     *
     * @param name - имя пользователя
     * @param age - возраст пользователя
     * @param job - место работы
     * @param address - адрес
     * @throws IllegalArgumentException - ошибка возникает когда одно из полей не проходит валидацию
     */
    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age less than 18");
        }
        if (!job.equals(VALID_JOBS[0])
                && !job.equals(VALID_JOBS[1])
                && !job.equals(VALID_JOBS[2])) {
            throw new IllegalArgumentException("Job is not valid");
        }
        if (!address.equals(VALID_ADDRESSES[0])
                && !address.equals(VALID_ADDRESSES[1])
                && !address.equals(VALID_ADDRESSES[2])) {
            throw new IllegalArgumentException("Address is not valid");
        }
        setJob(job);
        setAge(age);
        setName(name);
        setAddress(address);
    }

    /**
     * Метод принимает список пользователей, создает и заполняет мапу значениями, где
     * ключ-age, значение - пользователь с этим возрастом
     * в циклах итерируемся по map и строим строку с помощью StringBuilder.
     *
     * @param users список пользователей
     */

    public static void groupUser(ArrayList<User> users) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (User user : users) {
            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }
            userMap.get(user.getAge()).add(user);
        }
        for (Map.Entry<Integer, ArrayList<User>> entry : userMap.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<User> userList = entry.getValue();
            for (User user : userList) {
                result.append("| Key: ").append(key)
                        .append("| Name: ").append(user.getName())
                        .append("| Age: ").append(user.getAge())
                        .append("| Work Place: ").append(user.getJob())
                        .append("| Address: ").append(user.getAddress())
                        .append("\n");
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        try {
            User andrew = new User("Andrew", 45, "Google", "Amsterdam");
            User any = new User("Any", 18, "Google", "New York");
            users.add(andrew);
            users.add(any);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        groupUser(users);
    }
}
