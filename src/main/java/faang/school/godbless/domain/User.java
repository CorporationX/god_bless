package faang.school.godbless.domain;

import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activitys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getActivitys() {
        return activitys;
    }

    public void setActivitys(Set<String> activitys) {
        this.activitys = activitys;
    }

}