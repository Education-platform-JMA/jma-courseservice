package ru.jma.jmacourseservice.service.impl;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.service.InteractionService;

@Service
@RequiredArgsConstructor
public class UserInteractionService implements InteractionService {

    @Value("${jma.service.user}")
    private String serviceName;

    private final EurekaClient eurekaClient;

    @Override
    public <T> Mono<T> getMono(String uri, Class<T> responseClass) {
        return getWebClient(eurekaClient, serviceName)
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(responseClass);
    }
}
