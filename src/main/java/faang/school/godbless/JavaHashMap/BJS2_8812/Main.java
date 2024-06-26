package faang.school.godbless.JavaHashMap.BJS2_8812;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> numberAndNameEvent = new HashMap<>();
    static Map<String, List<StreamEvent>> typeEventAndListThisType = new HashMap<>();
    public static void main(String[] args) {
        addNewEvent(new StreamEvent(1,"Sport","Footboal playieng"));
        addNewEvent(new StreamEvent(2,"Sport","Footboal plaing"));
        addNewEvent(new StreamEvent(3,"Book","Reading book"));
        addNewEvent(new StreamEvent(4,"Zagadki","reshenie zagadok"));
        addNewEvent(new StreamEvent(5,"Sport", "Beg"));

        test(numberAndNameEvent);
        System.out.println();
        test1(typeEventAndListThisType);
        System.out.println();
    }
    public static void addNewEvent(StreamEvent event){
        numberAndNameEvent.putIfAbsent(event.getId(), event);
        List<StreamEvent> list = typeEventAndListThisType.getOrDefault(event.getEventType(), new ArrayList<>());
        list.add(event);
        typeEventAndListThisType.put(event.getEventType(),  list);
    }
    public static void searchEvent(Map map){
    }
    static void test(Map<Integer, StreamEvent> map){
        for (Map.Entry entry : map.entrySet()){
            System.out.println("Id: " + entry.getKey() + " " + entry.getValue());
        }
    }
    static void test1(Map<String, List<StreamEvent>> map){
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
