package ru.hogwarts.school.services.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.services.api.InfoService;
@Service
@Profile("production")
public class InfoServiceProduction implements InfoService {
    private final Environment environment;

    public InfoServiceProduction(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String getPort() {
        return environment.getProperty("local.server.port");
    }
}
