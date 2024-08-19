package data.centre;

import java.util.Scanner;

public class Main {

    public static DataCenter dataCenter = new DataCenter();
    public static DataCenterService dataCenterService = new DataCenterService();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        dataCenter = initDataCenter();
        dataCenterService.setOptimizationStrategy(new StoppingUnusedServersStrategy());

        ResourceRequest request = new ResourceRequest(500);
        ResourceRequest request1 = new ResourceRequest(1000);
        ResourceRequest request2 = new ResourceRequest(1500);
        ResourceRequest request3 = new ResourceRequest(300);

        dataCenterService.allocateResources(dataCenter, request);
        System.out.println("Общая нагрузка серверов " + dataCenterService.getTotalServerLoad(dataCenter));
        System.out.println("Потребление после первого выделения мощностей " +
                dataCenterService.getTotalEnergyConsumption(dataCenter));
        System.out.println("---");

        dataCenterService.allocateResources(dataCenter, request1);
        System.out.println("Общая нагрузка серверов " + dataCenterService.getTotalServerLoad(dataCenter));
        System.out.println("Потребление после второго выделения " +
                "мощностей и добавления нового сервера " + dataCenterService.getTotalEnergyConsumption(dataCenter));
        System.out.println("---");

        dataCenterService.releaseResources(dataCenter, request2);
        System.out.println("Общая нагрузка серверов после высвобождения ресурсов "
                + dataCenterService.getTotalServerLoad(dataCenter));
        System.out.println("Потребление энергии после высвобождения ресурсов " +
                dataCenterService.getTotalEnergyConsumption(dataCenter));
        System.out.println("---");

        dataCenterService.printServers(dataCenter);
        System.out.println("---");

        dataCenterService.allocateResources(dataCenter, request3);
        System.out.println("Общая нагрузка серверов " + dataCenterService.getTotalServerLoad(dataCenter));
        System.out.println("Потребление после третьего выделения мощностей " +
                dataCenterService.getTotalEnergyConsumption(dataCenter));
        System.out.println("---");

        try {
            selectingServerDeleteMethod();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        dataCenterService.optimize(dataCenter);
        System.out.println("---");

        dataCenterService.printServers(dataCenter);
    }

    public static DataCenter initDataCenter() {
        DataCenter dataCenter = new DataCenter();
        Server server1 = new Server(150, 300, 1.5);
        Server server2 = new Server(100, 350, 1);
        Server server3 = new Server(50, 300, 0.5);

        dataCenterService.addServer(dataCenter, server1);
        dataCenterService.addServer(dataCenter, server2);
        dataCenterService.addServer(dataCenter, server3);
        System.out.println("Общая нагрузка серверов " + dataCenterService.getTotalServerLoad(dataCenter));
        System.out.println("Потребление в начале " + dataCenterService.getTotalEnergyConsumption(dataCenter));
        System.out.println("---");
        return dataCenter;
    }

    public static void selectingServerDeleteMethod() {
        System.out.println("Введите команду: 'delete' или 'hard delete': ");
        String command = scanner.nextLine().trim();

        if (command.equalsIgnoreCase("delete")) {
            System.out.println("Введите ID сервера для удаления:");
            if (scanner.hasNextInt()) {
                int serverId = scanner.nextInt();
                scanner.nextLine();
                dataCenter.deleteServer(serverId);
            } else {
                System.out.println("Неверный ввод. Ожидалось число.");
                scanner.nextLine();
            }
        } else if (command.equalsIgnoreCase("hard delete")) {
            System.out.println("Введите ID сервера для удаления:");
            if (scanner.hasNextInt()) {
                int serverId = scanner.nextInt();
                scanner.nextLine();
                dataCenterService.hardDeleteServer(dataCenter, serverId);
            } else {
                System.out.println("Неверный ввод. Ожидалось число.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Неизвестная команда. Попробуйте снова.");
        }
        System.out.println("---");
    }
}
