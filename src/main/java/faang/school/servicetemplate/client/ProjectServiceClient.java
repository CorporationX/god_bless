package faang.school.servicetemplate.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "project-service", url = "${project-service.host}:${project-service.port}")
public interface ProjectServiceClient {

}
