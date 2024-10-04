package model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
public class Person {
    private long id = 0;
    private String name;
    private int age;
    private Set<String> activities;

    public Person(String name, int age, Set<String> activities) {
        ++this.id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<Person, String> findHobbyLovers(List<Person> personList, Set<String> activities) {
        var result = new HashMap<Person, String>();

        for (Person person : personList) {
            for (String activity : activities) {
                if (person.getActivities().contains(activity)) {
                    result.put(person, activity);
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getActivities(), person.getActivities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getActivities());
    }
}
