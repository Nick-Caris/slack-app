package asd.slack.Caris.Slackapp.controller;

import asd.slack.Caris.Slackapp.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SubwayController {

    @Autowired
    private SubwayService service;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Sub of the day app";
    }

    @RequestMapping("/sub")
    public Map<String, String> sub() {
        return service.getSubOfTheDay();
    }
}
