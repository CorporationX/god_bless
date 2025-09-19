package school.faang;

import java.util.ArrayList;
import java.util.Collections;

public class Example {
    public Example(){
    }
    public ArrayList<Integer> reverse(ArrayList<Integer> list){
        for (int i=1;i<=5;i++){
            list.add(i);
            System.out.println(list.get(i-1));
        }
        Collections.reverse(list);
        return list;
    }
}
