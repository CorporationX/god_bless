package work.stop;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingResources {
    private List<String> files;

    public void readFiles() {
        System.out.println("Чтение файлов из ресурсов маркетинга: " + this.files);
    }

    public void writeFile(String file) {
        this.files.add(file);
        System.out.println("Добавление файла в ресурс маркетинга: " + file);
    }
}
