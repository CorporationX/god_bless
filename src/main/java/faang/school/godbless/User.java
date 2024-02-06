package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private String[] aktiv;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getAktiv() {
        return aktiv;
    }

    public User(int id, String name, int age, String[] aktiv) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.aktiv = aktiv;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, String[] aktivis){
        Map<User, String> hobbyLoversMap = new HashMap<>();
        for (User user : users){
            String[] userAktivis = user.getAktiv();
            for (String activity : userAktivis){
                hobbyLoversMap.put(user, activity);
                break;
            }
        }
        return hobbyLoversMap;
    }

    public static void main(String args[]){
        List<User> users = new ArrayList<>();
        String[] hobbies1 = {"football", "basketball"};
        String[] hobbies2 = {"reading", "programming"};
        String[] hobbies3 = {"programming", "horses"};
        String[] hobbies4 = {"football", "horses"};
        String[] hobbies5 = {"programming", "reading"};

        User person1 = new User(1,"Karl", 20, hobbies1);
        User person2 = new User(2,"Mary", 28, hobbies2);
        User person3 = new User(3,"Stefan", 18, hobbies3);
        User person4 = new User(4,"Helga", 31, hobbies4);

        users.add(person1);
        users.add(person2);
        users.add(person3);
        users.add(person4);

        Map<User,String> findingHobbyLovers = findHobbyLovers(users, hobbies5);

        for(Map.Entry<User, String> entry : findingHobbyLovers.entrySet()){
            User user = entry.getKey();
            String activity = entry.getValue();
            System.out.println(user + " " + activity);
        }
    }
}


