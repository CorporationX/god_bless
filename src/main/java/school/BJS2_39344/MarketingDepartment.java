package school.BJS2_39344;

import lombok.Data;

import java.util.List;

@Data
public class MarketingDepartment implements Runnable {

    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
//        synchronized (designResources) {
//            System.out.println("Читаем данные из дизайн ресурсов");
//            List<String> listFromDesign = designResources.getList();
//            synchronized (marketingResources) {
//                System.out.println("Добавляют ресурсы в лист маркетинга");
//                marketingResources.addNameOfFile("Файл номер 2");
//            }
//        }
        System.out.println("Читаем данные из дизайн ресурсов");
        List<String> listFromDesign = designResources.getList();
        System.out.println("Добавляют файл в лист маркетинга");
        marketingResources.addNameOfFile("Файл номер 2");
    }
}