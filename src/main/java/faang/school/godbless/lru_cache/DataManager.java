package faang.school.godbless.lru_cache;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class DataManager {
    private final int CACHE_SIZE;

    private Map<Integer, Data> dataMap;
    private DataNode rootOfTree;
    private int currentNodeNumber;
    private Data[] dataTemporary;
    private int currentNumberOfData;

    public DataManager(int CACHE_SIZE) {
        this.dataMap = new HashMap<>();
        this.CACHE_SIZE = CACHE_SIZE;
        this.dataTemporary = new Data[CACHE_SIZE];
    }

    public void addData(Data data) {
        if (currentNumberOfData == CACHE_SIZE - 1) {
            deleteTheOldestData();
        }
        DataNode newNode = new DataNode(data);
        DataNode currentNode = rootOfTree;
        if (currentNode == null) {
            rootOfTree = newNode;
        } else {
            while (true) {
                if (currentNode.getData().getTimestamp() <= data.getTimestamp()) {
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(newNode);
                        break;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(newNode);
                        break;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                }
            }
        }
        dataMap.put(data.getId(), data);
        currentNumberOfData++;
    }

    public void deleteTheOldestData() {
        DataNode currentNode = rootOfTree;
        while (currentNode.getRightChild() != null) {
            currentNode = currentNode.getRightChild();
        }
        currentNode.getParent().setRightChild(null);
        dataMap.remove(currentNode.getData().getId());
        currentNumberOfData--;
    }

    public void reconstructDataTree() {

    }

    public void getBranches(DataNode dataNode){
        if(dataNode.getLeftChild() != null){
            getBranches(dataNode.getLeftChild());
        }

        getDataNode(dataNode);

        if(dataNode.getRightChild() != null){
            getBranches(dataNode.getRightChild());
        }
    }

    public void getDataNode(DataNode dataNode){
        dataTemporary[currentNodeNumber] = dataNode.getData();
        currentNodeNumber++;
    }
}
