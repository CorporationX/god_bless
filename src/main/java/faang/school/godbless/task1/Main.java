package faang.school.godbless.task1;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new LinkedList<>();
        users.add(new User("Alex",20,"Russia","123"));
        users.add(new User("Jon",22,"Russia","123"));
        users.add(new User("Jak",20,"Russia","123"));
        users.add(new User("Bob",20,"Russia","123"));
        users.add(new User("Mark",22,"Russia","123"));

        System.out.println(groupUsers(users));
    }

    public static Map<Integer, LinkedList<User>> groupUsers(List<User> users){
        Map<Integer, LinkedList<User>> sortsUsers= new HashMap<>();
        for (User i : users){
            if (sortsUsers.containsKey(i.getAge())){
                sortsUsers.get(i.getAge()).add(i);
            } else {
                LinkedList<User> newUser = new LinkedList<>();
                newUser.add(i);
                sortsUsers.put(i.getAge(),newUser);
            }
        }
        return sortsUsers;
    }
}
