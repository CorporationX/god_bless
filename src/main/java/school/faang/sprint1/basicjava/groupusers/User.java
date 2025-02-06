package school.faang.sprint1.basicjava.groupusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultMap = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!resultMap.containsKey(age)) {
                resultMap.put(age, new ArrayList<>());
            }
            resultMap.get(age).add(user);
        }
        return resultMap;
    }

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        userList.add(new User("Алексей", 23, "ТехноКорп", "ул. Ленина, 12"));
        userList.add(new User("Борис", 25, "ФинТех ООО", "пр. Советский, 45"));
        userList.add(new User("Виктор", 36, "РитейлМакс", "ул. Победы, 78"));
        userList.add(new User("Дмитрий", 18, "ДизайнСтудия", "пер. Парковый, 101"));
        userList.add(new User("Елена", 42, "ЗдравПлюс", "ул. Кирова, 202"));
        userList.add(new User("Фёдор", 23, "ОбразЦентр", "ул. Центральная, 303"));
        userList.add(new User("Григорий", 25, "МегаРитейл", "пер. Лесной, 404"));
        userList.add(new User("Галина", 36, "ФинансГрупп", "пр. Московский, 505"));
        userList.add(new User("Юлия", 42, "СофтНет Солюшнс", "ул. Лесопарковая, 707"));
        userList.add(new User("Константин", 23, "МедиаКо", "ул. Цветочная, 808"));
        userList.add(new User("Лариса", 25, "РитейлМакс", "пр. Городской, 909"));
        userList.add(new User("Михаил", 36, "СтройПравиль", "пер. Дачный, 123"));
        userList.add(new User("Наталья", 18, "ТехноМир", "ул. Полевая, 234"));
        userList.add(new User("Ольга", 42, "ФинТех ООО", "ул. Северная, 345"));
        userList.add(new User("Павел", 23, "ДизайнСтудия", "пр. Южный, 456"));
        userList.add(new User("Квинси", 25, "ОбразЦентр", "ул. Берёзовая, 567"));
        userList.add(new User("Рита", 36, "ЗдравПлюс", "ул. Вишнёвая, 678"));
        userList.add(new User("Станислав", 18, "МегаРитейл", "пер. Академический, 789"));
        userList.add(new User("Татьяна", 42, "СофтНет Солюшнс", "ул. Дубравная, 890"));

        System.out.println(groupUsers(userList));
    }
}
