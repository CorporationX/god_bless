package BJS218489;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User Mathew = new User("Mathew",21,"student","Segezha");
        User Egor = new User("Egor",18,"student","Petrozavodsk");
        User Yarik = new User("Yarik",16,"none","Petrozavodsk");
        List<User> list = List.of(Mathew,Egor,Yarik);
        System.out.println("Перебор ключ значения:" + User.groupList(list));
    }
}
