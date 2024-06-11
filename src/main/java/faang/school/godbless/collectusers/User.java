package faang.school.godbless.collectusers;

import faang.school.godbless.helpers.CustomException;

import java.util.*;

public class User {
    public int id;
    public String name;
    public Set<String> activities;

    public User(String name, int id, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.activities = activities;
    }
    public static Map<User,String> findHobbyLovers(List<User> users,Set<String> activities) throws CustomException {
        Map<User,String> resultMap = new HashMap<>();
        if(users.isEmpty()){
            throw new CustomException("User list is empty");
        }
        if(activities.isEmpty()) {
            throw new CustomException("Activities list is empty");
        }
        activities.forEach(activity->{
            Optional<User> resultUser = users.stream().filter(el->el.activities.contains(activity)).findFirst();
            resultUser.ifPresent(user -> resultMap.put(user, activity));
        });
        return resultMap;
    }

    public static void main(String[] args) {
        User userOne = new User("Ali",1,Set.of("It","Games","Travel"));
        User userTwo = new User("John",2,Set.of("Cars","Sport"));
        User userThree = new User("David",3,Set.of("Planes","Hiking"));
        try {
            Map<User,String> hobbyLovers= findHobbyLovers(List.of(userOne,userTwo,userThree),Set.of("Planes","It"));
            for (Map.Entry<User,String> item : hobbyLovers.entrySet()) {
                System.out.println("name "+item.getKey().name+" hobby "+item.getValue());
            }
        } catch (CustomException e) {
            e.printError();
        }
    }
}
