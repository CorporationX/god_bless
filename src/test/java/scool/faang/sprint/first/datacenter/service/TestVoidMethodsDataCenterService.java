package scool.faang.sprint.first.datacenter.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.ResourceRequest;
import school.faang.sprint.first.datacenter.model.Server;
import school.faang.sprint.first.datacenter.service.DataCenterService;
import school.faang.sprint.first.datacenter.service.impl.EnergyEfficiencyOptimizationStrategy;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestVoidMethodsDataCenterService {
    private final DataCenterService dataCenterService =
            new DataCenterService(new EnergyEfficiencyOptimizationStrategy());

    @Mock
    private DataCenter dataCenter;

    @Mock
    private ResourceRequest request;

    @Mock
    private Server server1;
    @Mock
    private Server server2;

    @Test
    public void testReleaseResources() {
        when(request.getLoad()).thenReturn(15.0);
        when(dataCenter.getServers()).thenReturn(Arrays.asList(server1, server2));

        when(server1.getLoad()).thenReturn(10.0);
        when(server2.getLoad()).thenReturn(10.0);

        dataCenterService.releaseResources(dataCenter, request);

        verify(server1).setLoad(0);
        verify(server2).setLoad(5.0);
    }
}
