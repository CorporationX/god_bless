package Grouping_by_age_BJS2_67955;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) { //конструктор
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

}
