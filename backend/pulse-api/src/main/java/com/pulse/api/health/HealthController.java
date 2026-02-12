package com.pulse.api.health;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "service", "pulse-api"
        );
    }
}