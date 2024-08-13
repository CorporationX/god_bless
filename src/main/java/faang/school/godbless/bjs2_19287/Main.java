package faang.school.godbless.bjs2_19287;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // pattern "Strategy"
        var service1 = new DataCenterService(new LoadBalancingOptimizationStrategy());
        var service2 = new DataCenterService(new EnergyEfficiencyOptimizationStrategy());

        /**
         * Default Max Load = 100.0
         */
        var service = new DataCenterService(new EnergyEfficiencyOptimizationStrategy());
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. Display Data Center state");
            System.out.println("2. Add server");
            System.out.println("3. Add server and turn on");
            System.out.println("4. Allocate Resources");
            System.out.println("5. Release Resources");
            System.out.println("6. Optimize Data Center");
            System.out.println("7. Display not active servers");
            System.out.println("0. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    service.printState();
                    break;
                case 2:
                    service.addServer();
                    break;
                case 3:
                    service.addServerAndTurnOn();
                    break;
                case 4:
                    System.out.print("Enter load value: ");
                    double loadToAllocate = scanner.nextDouble();
                    service.allocateResources(new ResourceRequest(loadToAllocate));
                    break;
                case 5:
                    System.out.print("Enter load value: ");
                    double loadToRelease = scanner.nextDouble();
                    service.releaseResources(new ResourceRequest(loadToRelease));
                    break;
                case 6:
                    service.optimize();
                    break;
                case 7:
                    service.printNotActiveServers();
                    break;
                case 0:
                    System.out.println("Exiting the program");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
