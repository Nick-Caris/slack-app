package asd.slack.Caris.Slackapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SubwayController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Sub of the day app";
    }

    @RequestMapping("/sub")
    public Map<String, String> sub() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("response_type", "in_channel");
        map.put("text", "Chicken filet");

        return map;
    }
}
