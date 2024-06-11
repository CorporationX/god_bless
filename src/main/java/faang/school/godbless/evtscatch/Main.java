package faang.school.godbless.evtscatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer,StreamEvent> mapOne = new HashMap<>();
    private static final Map<String, List<StreamEvent>> mapTwo = new HashMap<>();
    public static void main(String[] args) {
        addEvent(1,"click","123");
        addEvent(2,"scroll","1234");
        addEvent(3,"hover","12345");
        addEvent(4,"click","1122");
        addEvent(5,"click","1122");
        StreamEvent evt = getEventById(3);
        List<StreamEvent> eventsByType = getEventsByType("click");
        deleteById(5);
        System.out.println(mapOne.get(5));
        getInfo();
    }
    public static void getInfo() {
        for(Map.Entry<Integer,StreamEvent> el: mapOne.entrySet()) {
            System.out.printf("id %d %s %s",el.getValue().getId(),el.getValue().getData(),el.getValue().getType());
            System.out.println();
        }
    }
    public static void deleteById(Integer id) {
        mapOne.computeIfPresent(id,(k,v)->{
            mapTwo.computeIfPresent(v.getType(),(a,b)->b.stream().filter(el-> el.getId() != v.getId()).toList());
            return null;
        });
    }
    public static StreamEvent getEventById(Integer id) {
        StreamEvent result = mapOne.get(id);
        return result;
    }
    public static List<StreamEvent> getEventsByType(String type) {
        List<StreamEvent> result = mapTwo.get(type);
        return result;
    }
    public static void addEvent(Integer id,String type,String data){
        List<StreamEvent> evtList = new ArrayList<>();
        StreamEvent streamEvent = new StreamEvent(id,type,data);
        mapOne.put(id,streamEvent);
        mapTwo.computeIfAbsent(type, k -> new ArrayList<>()).add(streamEvent);
    }
}
