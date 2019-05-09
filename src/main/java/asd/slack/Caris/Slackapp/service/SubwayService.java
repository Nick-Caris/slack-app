package asd.slack.Caris.Slackapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubwayService {


    /**
     * @return Map
     */
    public Map<String, String> getSubOfTheDay() {
        Map<String, String> map = new HashMap<>();
        String[] subs = new RestTemplate().getForObject("http://127.0.0.1:5000/subs", String[].class);
        Date now = new Date();

        map.put("response_type", "in_channel");
        map.put("text", subs[now.getDay() - 1]);


        return map;
    }
}
