package ru.hogwarts.school.services.info;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.services.api.InfoService;

@Service
@Profile("!production")
public class infoServiceTest implements InfoService {
    @Override
    public String getPort() {
        return "test-port";
    }
}
