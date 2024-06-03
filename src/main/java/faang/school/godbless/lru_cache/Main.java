package faang.school.godbless.lru_cache;

import lombok.ToString;

import java.util.*;

//Node class to construct double linked list
class Node {
    public Node (Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public Data data;
    public Node next;
    public Node prev;
}

public class Main {
    int CACHE_SIZE;
//    db or some other type of storage
    List<Data> storage = new ArrayList<>();
    Map<Integer, Node> cache = new HashMap<>();
    Node head, tail;

    public Main(int cache_size) {
        CACHE_SIZE = cache_size;
    }

    public Data get(int key) {
        Node d = cache.get(key);

        if (d != null) {
//            node is head
            if(head.equals(d)) {
                return d.data;
            }

            Node oldHead = head;
            head = d;

//            node is tail
            if(tail.equals(d)) {
                tail = tail.next;
            }

//            node in the middle, i guess could also be run as else in tail check
            if(d.next != null && d.prev != null) {
                d.prev.next = d.next;
                d.next.prev = d.prev;
            }

            oldHead.next = d;
            d.next = null;
            d.prev = oldHead;

            return d.data;
        }

//        If data not found in cache find in storage and put in cache
        for (Data data : storage) {
            if (data.id == key) {
                Node newNode = new Node(data);
//                assigning for return value
                d = newNode;

                Node oldHead = head;
                head = newNode;

//                runs if there is something in cache already
                if(oldHead != null) {
                    oldHead.next = newNode;
                    newNode.prev = oldHead;
                }

//                if no tail, set it to tail
                if(tail == null) {
                    tail = newNode;
                }

                cache.put(key, head);
            }
        }

//        is cache is full remove oldest element
        if (cache.size() > CACHE_SIZE) {
            cache.remove(tail.data.id);
            tail = tail.next;
        }

        if (d == null) { return null; }
        return d.data;
    }

//    Since not stated otherwise put doesnt update cache
    public void put(Data data) {
        storage.add(data);
    }

//    Prints head and tail nodes + outputs contents of a map
//    Returns an array of size 2+CACHE_SIZE.  First two values are head and tail and other ones are ids in asc order
    public int[] getCacheStatus() {
//        first 2 values head and tail id's
        int[] arrayStatus = new int[2+CACHE_SIZE];
        Arrays.fill(arrayStatus, -1);
        if(head != null) {
            arrayStatus[0] = head.data.id;
        }
        if(tail != null ) {
            arrayStatus[1] = tail.data.id;
        }

        System.out.println("===================");
        System.out.println("Tail " + tail + "; Head " + head);
        int i = 2;
        for (Map.Entry<Integer, Node> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            arrayStatus[i] = entry.getKey();
            i++;
        }
        return arrayStatus;
    }
}
