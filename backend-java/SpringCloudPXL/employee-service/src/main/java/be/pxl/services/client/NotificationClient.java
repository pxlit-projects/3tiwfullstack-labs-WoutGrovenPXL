package be.pxl.services.client;

import be.pxl.services.api.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8084") // -> naam van de service
public interface NotificationClient {

    @PostMapping("/api/notification")
    void sendNotification(@RequestBody NotificationRequest notifictionRequest);
}

