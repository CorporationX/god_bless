package faang.school.godbless.Sprint4.MiceAreVeryNice;


import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Room {
    private String name;
    private List<Food> foods=new LinkedList<>();

    Room(String name){
        this.name=name;
    }
}
