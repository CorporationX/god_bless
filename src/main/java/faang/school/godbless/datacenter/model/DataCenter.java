package faang.school.godbless.datacenter.model;

import lombok.NonNull;

import java.util.List;

public record DataCenter(@NonNull List<Server> servers) {

}
