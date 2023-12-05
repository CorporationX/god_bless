package faang.school.godbless._Grouping_users;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public String name;
    public static int age;
    public String  work_place;
    public String address;

    public static HashMap<Integer,ArrayList> groupUsers(ArrayList<User> users){
        ArrayList<User> us = users;
        ArrayList<User> group=new ArrayList<>();
        HashMap<Integer,ArrayList> mapUsers = new HashMap<>();
        mapUsers.put(age,group);
        for(User user :us){
            if( mapUsers.containsKey(user.age)){

            }else{
                ArrayList<User> gr = new ArrayList<>();
                gr.add(user);
                mapUsers.put(user.age,group );
            }
        }
        return mapUsers;

    }
}
