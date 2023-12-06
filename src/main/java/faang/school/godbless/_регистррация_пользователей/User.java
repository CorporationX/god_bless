package faang.school.godbless._регистррация_пользователей;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class User {
    public String name;
    public static int age;
    public String  work_place;
    public String address;
    final static Set<String> VALID_JOBS =Set.of("Google","Uber","Amazon");
    final static Set<String> VALID_ADDRESSES= Set.of("London","New York","Amsterdam");
    final static int age1 =18;

    public User(String name,int age,String work_place,String address){
        this.name=name;
        this.age=age;
        this.work_place=work_place;
        this.address=address;
        if(name.isEmpty()){

        }else if( )


    }

    public static HashMap<Integer, ArrayList> groupUsers(ArrayList<User> users){
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
