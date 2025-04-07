package school.faang;

import school.faang.Group_Users_By_Age.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> johns = new ArrayList<>();
        johns.add(new User("John1",20));
        johns.add(new User("John2",21));
        johns.add(new User("John3",26));
        johns.add(new User("John4",28));
        johns.add(new User("John5",22));
        johns.add(new User("John6",20));
        johns.add(new User("John7",23));
        johns.add(new User("John8",28));
        johns.add(new User("John9",26));
        johns.add(new User("John10",21));

        System.out.println(User.groupUsers(johns));
    }
}
