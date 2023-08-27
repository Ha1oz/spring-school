package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.services.api.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/getPort")
    public String getPortInfo(){
        return infoService.getPort();
    }
    @GetMapping("/value")
    public Long getValue() {
        return infoService.getValue();
    }
}
