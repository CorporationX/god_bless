package faang.school;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MarketingResources {
    //    private final List<String> paths = new CopyOnWriteArrayList<>();
    private final List<String> paths = new ArrayList<>();

    public synchronized void addPath(String path){
        paths.add(path);
    }
    public synchronized List<String> getPaths(){
        return new ArrayList<>(paths);
    }

}
