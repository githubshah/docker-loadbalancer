package com.my.navigation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MapNavigationController {

    @GetMapping
    public String getRiderLocation() {
        return "ok-v2";
    }

    @GetMapping("/v1/location")
    public String getRiderLocation(@RequestParam("riderId") String riderId) {

        Map<String, String> location = new HashMap<>();
        location.put("1", "bhongaon-v2");
        location.put("2", "mainpuri-v2");
        location.put("3", "delhi-v2");

        return location.get(riderId);
    }
}
