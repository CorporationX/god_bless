package faang.school.godbless.collecting_users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User user)) return false;

        return this.id == user.id &&
                this.name.equals(user.name) &&
                this.age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies){
        Map<User, String> result = new HashMap<>();

        for(User user : users){
            for(String hobby : hobbies){
                if(user.activities.contains(hobby)){
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }
}
