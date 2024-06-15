package group_by_age;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            logger.error("Error converting User to JSON", e);
            return "";
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapOfUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!mapOfUsers.containsKey(age)) {
                mapOfUsers.put(age, new ArrayList<>());
            }
            mapOfUsers.get(age).add(user);
        }
        return mapOfUsers;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", 30, "ООО Конфетки-бараночки", "ул. Ленина, 123"));
        users.add(new User("Мария", 26, "ООО Аналитик", "пр. Победы, 56"));
        users.add(new User("Алексей", 30, "Дизайн-студия ArtDesign", "ул. Садовая, 7"));
        users.add(new User("Елена", 28, "Компания Менеджеров", "пр. Гагарина, 14"));
        users.add(new User("Павел", 31, "Инженерная компания TechSolutions", "ул. Центральная, 29"));
        users.add(new User("Ольга", 30, "Бухгалтерия ФинансГарант", "пр. Ленинградский, 5"));
        users.add(new User("Дмитрий", 34, "ООО Программисты-эксперты", "ул. Московская, 11"));
        users.add(new User("Анна", 31, "ООО Аналитики-профи", "пр. Кирова, 3"));
        users.add(new User("Сергей", 34, "Компания Успешных Менеджеров", "ул. Пушкина, 17"));
        users.add(new User("Наталья", 26, "Студия Дизайна CreativeArt", "пр. Советский, 8"));

        Map<Integer, List<User>> groupedUsers = groupUsers(users);
        System.out.println(groupedUsers);
    }
}