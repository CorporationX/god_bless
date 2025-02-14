package bjs257883;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        People people = new People();
        Map<String, List<String>> initializedData = getInitializedData();
        logger.info("{}", people.findPeopleWithMutualFriends(initializedData));
    }

    private static Map<String, List<String>> getInitializedData() {
        Map<String, List<String>> nameToFriends = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Bob");
        list1.add("Charlie");
        nameToFriends.put("Alice", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Alice");
        list2.add("David");
        nameToFriends.put("Bob", list2);

        List<String> list3 = new ArrayList<>();
        list3.add("Alice");
        list3.add("David");
        nameToFriends.put("Charlie", list3);

        List<String> list4 = new ArrayList<>();
        list4.add("Bob");
        list4.add("Charlie");
        nameToFriends.put("David", list4);

        return nameToFriends;
    }
}
