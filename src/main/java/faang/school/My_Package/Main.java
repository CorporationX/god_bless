package faang.school.My_Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> Actinosty = Set.of("Hockey","Volleyball","Football","Gandball","Baseball");
        User user = new User();
        User matvey = new User(1,3,"Matvey", Set.of("Hockey","Volleyball"));
        User egor = new User(2,3,"Egor",Set.of("Gaming","HomeSitting"));
        List<User> guys = List.of(matvey,egor);
        System.out.println(user.findHobbyLovers(guys,Actinosty));
    }
}
