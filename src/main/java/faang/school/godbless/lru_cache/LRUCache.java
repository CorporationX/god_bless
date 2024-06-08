package faang.school.godbless.lru_cache;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
class LRUCache {
    private final int CACHE_SIZE;

    private Map<Integer, DataNode> map;
    private DataNode head;
    private DataNode tail;
    private Database database;
    public LRUCache(int CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
        this.map = new HashMap<>();
        this.database = new Database(new HashMap<>());
    }

    public String get(int key) {
        if(map.containsKey(key)){
            DataNode dataNode = map.get(key);
            removeNode(dataNode);
            addToHead(dataNode);
            return dataNode.getData().getValue();
        } else {
            Data data = database.getData(key);
            DataNode dataNode = new DataNode(data);
            put(key, dataNode);
            if(data.getValue() == null){
                log.warn("Could not find data in database");
                return null;
            } else {
                return data.getValue();
            }
        }
    }

    public void put(int key, DataNode dataNode) {
        if(map.containsKey(key)){
            DataNode node = map.get(key);
            node.setData(dataNode.getData());
            removeNode(node);
            addToHead(node);
        } else {
            if(map.size() == CACHE_SIZE){
                int nodeToDelete = removeTail();
                map.remove(nodeToDelete);
            }
            addToHead(dataNode);
            map.put(key, dataNode);
        }
    }

    public void removeNode(DataNode dataNode){
        if(dataNode == head){
            if(dataNode == tail){
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrevious(null);
            }
        } else if(dataNode == tail){
            tail = tail.getPrevious();
        } else {
            dataNode.getPrevious().setNext(dataNode.getNext());
            dataNode.getNext().setPrevious(dataNode.getPrevious());
        }
    }

    public void addToHead(DataNode dataNode){
        dataNode.getData().setTimestamp(System.currentTimeMillis());
        if(head == null){
            head = dataNode;
            tail = dataNode;
        } else {
            head.setPrevious(dataNode);
            dataNode.setNext(head);
            head = dataNode;
            dataNode.setPrevious(null);
        }
    }

    public int removeTail(){
        int key = tail.getData().getId();
        if(head == tail){
            tail = null;
            head = null;
        } else {
            tail = tail.getPrevious();
        }
        return key;
    }
}
