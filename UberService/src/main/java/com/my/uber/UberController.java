package com.my.uber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.net.InetAddress;

@RestController
public class UberController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(UberController.class);

    // simple instance identifier (prefer Docker's HOSTNAME env which is the container id)
    private final String instanceId;

    public UberController() {
        String id = System.getenv("HOSTNAME");
        if (id == null || id.isEmpty()) {
            try {
                id = InetAddress.getLocalHost().getHostName();
            } catch (Exception e) {
                id = "unknown";
            }
        }
        this.instanceId = id;
    }

    @GetMapping
    public String ok() {
        return "ok - instance:" + instanceId;
    }

    @GetMapping("/v1/location")
    public String getV1RiderLocation(@RequestParam("riderId") String riderId) {
        log.info("v1 location api called " + LocalDateTime.now());

        String BASE_URL = "http://localhost:8081";
        String URI = "/map/v2/location";
        String url = BASE_URL + URI + "?riderId=" + riderId;

        String resp = restTemplate.getForObject(url, String.class);
        return "instance:" + instanceId + " -> " + resp;
    }

    @GetMapping("/v3/location")
    public String getV1RiderLocationV3(@RequestParam("riderId") String riderId) {
        log.info("v1 location api called " + LocalDateTime.now());


        String BASE_URL = "http://map-service:8081";
        String URI = "/map/v2/location";
        String url = BASE_URL + URI + "?riderId=" + riderId;

        String resp = restTemplate.getForObject(url, String.class);
        return "instance:" + instanceId + " -> " + resp;
    }

    @GetMapping("/instance")
    public String instance() {
        return instanceId;
    }
}
