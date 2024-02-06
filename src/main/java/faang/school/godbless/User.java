package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private String[] aktiv;

    public User(int id, String name, int age, String[] aktiv) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.aktiv = aktiv;
    }

    public void findHobbyLovers(List<users>){

    }

    public static void main(String args[]){
        List<User> users = new ArrayList<>();
        String[] hobbies1 = {"football", "basketball"};
        String[] hobbies2 = {"reading", "programming"};
        String[] hobbies3 = {"programming", "horses"};
        String[] hobbies4 = {"football", "horses"};
        User person1 = new User(1,"Karl", 20, hobbies1);
        User person2 = new User(2,"Mary", 28, hobbies1);
        User person3 = new User(3,"Stefan", 18, hobbies1);
        User person4 = new User(4,"Helga", 31, hobbies1);
    }
}


