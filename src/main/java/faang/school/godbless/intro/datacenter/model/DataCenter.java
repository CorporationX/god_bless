package faang.school.godbless.intro.datacenter.model;

import lombok.NonNull;

import java.util.List;

public record DataCenter(@NonNull List<Server> servers) {

}
