package school.faang.artemon.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * \Создать класс User с полями:
 *     name — имя пользователя;
 *     age — возраст пользователя;
 *     workplace — место работы пользователя;
 *     address — адрес пользователя.
 */
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    /**
     * Добавить в класс User статический метод groupUsers(List‹User›), который:
     *     Принимает список объектов класса User.
     *     Возвращает Map‹Integer, List‹User››, где: ключ — возраст пользователя; значение — список всех пользователей
     *     из исходного списка с этим возрастом.
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> result;
        result = users.stream().collect(Collectors.groupingBy(User::getAge));
        return result;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", workplace='" + workplace + '\''
                + ", address='" + address + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workplace, user.workplace)
                && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }
}
