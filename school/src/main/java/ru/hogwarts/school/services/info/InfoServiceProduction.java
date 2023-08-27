package ru.hogwarts.school.services.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.services.api.InfoService;

import java.util.stream.Stream;

@Service
@Profile("!production")
public class InfoServiceProduction implements InfoService {
    private final Environment environment;

    public InfoServiceProduction(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String getPort() {
        return environment.getProperty("local.server.port");
    }

    @Override
    public Long getValue() {
        long sum = Stream
                .iterate(1, a -> a + 1)
                .limit(1000000)
                .parallel()
                .reduce(0, Integer::sum);

        return sum;
    }

}
