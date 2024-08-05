package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> otherHobbies) {
        Map<User, String> hobbyCoincidenceMap = new HashMap<>();
        for(User user : users) {
            for (String hobby : otherHobbies) {
                if (user.getHobbies().contains(hobby)) {
                    hobbyCoincidenceMap.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyCoincidenceMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getId().equals(user.getId())) return false;
        return getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}