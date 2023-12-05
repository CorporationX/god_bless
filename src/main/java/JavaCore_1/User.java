package JavaCore_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public void setName(String name) {
        if ((!name.equals(" ")) && (!name.equals("")) && (name!=null))
            this.name = name;
    }

    public void setAge(int age) {
        if ((age>0) && (age<150))
            this.age = age;
    }

    public void setJob(String job) {
        if ((!job.equals(" ")) && (!job.equals("")) && (job!=null))
            this.job = job;
    }

    public void setAddress(String address) {
        if ((!address.equals(" ")) && (!address.equals("")) && (address!=null))
            this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

    static public Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> usersReturn = new HashMap<Integer, List<User>>();
        for (User user: users) {
            if (usersReturn.containsKey(user.getAge())){
                usersReturn.get(user.getAge()).add(user);
            } else {
                usersReturn.put(user.getAge(), new ArrayList<User>());
                usersReturn.get(user.getAge()).add(user);
            }
        }
        return usersReturn;
    }
}
