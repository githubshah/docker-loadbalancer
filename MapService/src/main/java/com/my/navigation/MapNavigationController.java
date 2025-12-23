package com.my.navigation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MapNavigationController {

    @GetMapping("/v1/location")
    public String getRiderLocation(@RequestParam("riderId") String riderId) {

        Map<String, String> location = new HashMap<>();
        location.put("1", "bhongaon");
        location.put("2", "mainpuri");
        location.put("3", "delhi");

        return location.get(riderId);
    }
}
