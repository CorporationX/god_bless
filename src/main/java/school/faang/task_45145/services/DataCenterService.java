package school.faang.task_45145.services;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.ResourceRequest;
import school.faang.task_45145.models.Server;
import school.faang.task_45145.strategies.OptimizationStrategy;

import java.util.List;
import java.util.Set;

@Slf4j
@Setter
public class DataCenterService {
    private final DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;

        log.info("Successfully initialized DataCenterService for '{}'", dataCenter.getName());
    }

    public boolean addServer(Server server) {
        if (dataCenter.getServers().contains(server)) {
            log.warn("Server '{}' already exists in Data Center '{}'", server.getName(), dataCenter.getName());
            return false;
        }

        dataCenter.getServers().add(server);

        log.info("Server '{}' successfully added to the Data Center '{}'", server.getName(), dataCenter.getName());
        return true;
    }

    public boolean removeServer(Server server) {
        if (dataCenter.getServers().remove(server)) {
            log.info("Server '{}' removed from Data Center '{}'", server.getName(), dataCenter.getName());
            return true;
        }

        log.warn("Server '{}' does not exist in Data Center '{}'.", server.getName(), dataCenter.getName());
        return false;
    }

    public double getTotalEnergyConsumption() {
        final Set<Server> servers = getServers();

        if (servers == null) {
            return 0.0;
        }

        final double totalEnergyConsumption = servers.stream().mapToDouble(Server::getEnergyConsumption).sum();

        log.debug(
                "Total energy consumption calculated for Data Center '{}': {}",
                dataCenter.getName(),
                totalEnergyConsumption
        );
        return totalEnergyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        double remainingRequestLoad = request.getLoad();
        final Set<Server> servers = getServers();

        if (servers == null || servers.isEmpty() || remainingRequestLoad <= 0) {
            log.warn("Resource allocation failed: No servers available, or invalid load requested.");
            return false;
        }

        final double totalAvailableCapacity = calculateTotalAvailableCapacity(servers);
        if (totalAvailableCapacity < remainingRequestLoad) {
            log.warn("Insufficient resources available for allocation: Available '{}', Requested '{}'.",
                    totalAvailableCapacity,
                    remainingRequestLoad);
            log.warn("Please adjust the requested load or server configuration.");
            return false;
        }

        final String dataCenterName = dataCenter.getName();
        final double originalRequestedLoad = request.getLoad();

        log.info(
                "Starting resource allocation: Requested load '{}' for Data Center '{}'",
                remainingRequestLoad,
                dataCenterName
        );

        for (Server server : servers) {
            final double availableCapacity = server.getMaxLoad() - server.getLoad();

            if (availableCapacity > 0) {
                final double appliedLoad = Math.min(availableCapacity, remainingRequestLoad);
                server.setLoad(server.getLoad() + appliedLoad);
                remainingRequestLoad -= appliedLoad;

                log.info(
                        "Server '{}' allocated '{}' load. Remaining load to allocate: '{}'",
                        server.getName(),
                        appliedLoad,
                        remainingRequestLoad
                );

                if (remainingRequestLoad <= 0) {
                    log.info(
                            "Successfully allocated '{}' load across servers in Data Center '{}'.",
                            originalRequestedLoad,
                            dataCenterName
                    );
                    return true;
                }
            }
        }

        log.warn(
                "Partial allocation: Unable to allocate '{}' load in Data Center '{}'. Unallocated load: '{}'.",
                originalRequestedLoad,
                dataCenterName,
                remainingRequestLoad
        );
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        double loadToRelease = request.getLoad();
        if (loadToRelease <= 0) {
            log.warn("Resource release failed: Requested load is zero or negative.");
            return false;
        }

        final Set<Server> servers = dataCenter.getServers();
        if (servers == null || servers.isEmpty()) {
            log.warn("Resource release failed: No servers available in Data Center '{}'.", dataCenter.getName());
            return false;
        }

        final List<Server> sortedServers = servers.stream()
                .sorted((s1, s2) -> Double.compare(s2.getLoad(), s1.getLoad()))
                .toList();

        for (Server server : sortedServers) {
            final double currentLoad = server.getLoad();
            final double loadReduction = Math.min(currentLoad, loadToRelease);
            server.setLoad(currentLoad - loadReduction);
            log.info("Server '{}' released '{}' load.", server.getName(), loadReduction);
            loadToRelease -= loadReduction;

            if (loadToRelease <= 0) {
                log.info(
                        "Successfully released '{}' load from servers in Data Center '{}'.",
                        request.getLoad(),
                        dataCenter.getName()
                );
                return true;
            }
        }

        log.warn(
                "Partial release: Unable to release '{}' load in Data Center '{}'. Remaining load: '{}'.",
                request.getLoad(),
                dataCenter.getName(),
                loadToRelease
        );
        return false;
    }

    public void optimize() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
            log.info("Optimization successfully completed for Data Center '{}'.", dataCenter.getName());
        } else {
            log.warn("Optimization aborted: No optimization strategy defined.");
        }
    }

    public void startPeriodicOptimization(long intervalInMillis) {
        for (int i = 0; i < 2; i++) {
            log.info("[Periodic Optimization] Cycle: {}", i + 1);

            optimize();

            try {
                Thread.sleep(intervalInMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("[Periodic Optimization] Interrupted. Stopping.");
                break;
            }
        }
    }

    protected double calculateTotalAvailableCapacity(Set<Server> servers) {
        return servers.stream()
                .mapToDouble(server -> server.getMaxLoad() - server.getLoad())
                .filter(capacity -> capacity > 0)
                .sum();
    }

    protected Set<Server> getServers() {
        final Set<Server> servers = dataCenter.getServers();

        if (servers == null || servers.isEmpty()) {
            log.warn("No servers found in Data Center '{}'", dataCenter.getName());
            return null;
        }
        return servers;
    }
}
