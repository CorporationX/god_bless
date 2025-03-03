package school.faang.theworkstands;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public abstract class DepartmentResources {

    protected final List<String> fileNames;

    protected DepartmentResources() {
        this.fileNames = new CopyOnWriteArrayList<>();
    }

    public void addFile(@NonNull String name) {
        fileNames.add(name);
    }
}
