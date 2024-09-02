package work.stop;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignResources {
    private List<String> files;

    public void readFiles() {
        System.out.println("Чтение файлов из ресурсов дизайнеров: " + this.files);
    }

    public void writeFile(String file) {
        files.add(file);
        System.out.println("Добавление файла в ресурс дизайнеров: " + file);
    }
}
