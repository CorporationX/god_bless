package faang.school.godbless.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private int age;
    private ArrayList<String> activities;

    public User(int id, String name, int age, ArrayList<String> activities){
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public ArrayList<String> getActivities(){
        return activities;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return id == other.id && age == other.age && name.equals(other.name)
                && activities.equals(other.activities);
    }

}
