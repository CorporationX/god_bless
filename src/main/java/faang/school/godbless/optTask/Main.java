package faang.school.godbless.optTask;

import faang.school.godbless.optTask.data.DataCenter;
import faang.school.godbless.optTask.data.DataCenterService;
import faang.school.godbless.optTask.data.ResourceRequest;
import faang.school.godbless.optTask.data.Server;
import faang.school.godbless.optTask.optStrategy.SequentialFilling;
import faang.school.godbless.optTask.optStrategy.UniformDistribution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        DataCenter dataCenter = new DataCenter(Arrays.asList(
                new Server(100, 230, 300),
                new Server(120, 400, 600),
                new Server(20, 100, 100)
        ));
        DataCenterService service = new DataCenterService(
                dataCenter, new UniformDistribution());

        try {
            service.startOptimization();
            service.allocateResources(new ResourceRequest(200));
            Thread.sleep(2000);
            service.allocateResources(new ResourceRequest(200));
            Thread.sleep(2000);
            service.releaseResources(new ResourceRequest(400));
            service.stopOptimization();
        }catch (InterruptedException e){
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted" );
            throw new RuntimeException();
        }

    }


}
