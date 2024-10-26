package school.BJS2_39344;

import lombok.Data;

import java.util.List;

@Data
public class DesignDepartment implements Runnable {

    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
//        synchronized (marketingResources) {
//            System.out.println("Читаем данные из маркетинг ресурсов");
//            List<String> listFromMarketing = marketingResources.getList();
//            synchronized (designResources) {
//                System.out.println("Добавляют ресурсы в лист дизайна");
//                designResources.addNameOfFile("Файл номер 1");
//            }
//        }
        System.out.println("Читаем данные из маркетинг ресурсов");
        List<String> listFromMarketing = marketingResources.getList();
        System.out.println(listFromMarketing);
        System.out.println("Добавляют файл в лист дизайна");
        designResources.addNameOfFile("Файл номер 1");
    }
}
