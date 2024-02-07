package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class UserGroup {
    private String name;
    private int age;
    private String work;
    private String address;
    public UserGroup(String name, int age, String work, String address){
        this.name=name;
        this.age=age;
        this.work=work;
        this.address=address;
    }

    public String getName(){

        if(getName().isEmpty()){

        }
        return name;
    }
    public Integer getAge(){
        if(getAge()<18){

        }
        return age;
    }
    public String getWork(){
        return work;
    }
    public String getAddress(){
        return getAddress();
    }

    public static Map<Integer,  List<UserGroup>>groupUsers(List<UserGroup>users){
        return users.stream().collect(Collectors.groupingBy(UserGroup::getAge));
    }
}
