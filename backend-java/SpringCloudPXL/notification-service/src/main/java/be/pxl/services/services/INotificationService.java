package be.pxl.services.services;

import be.pxl.services.api.request.NotificationRequest;

public interface INotificationService {

    void sendNotification(NotificationRequest notificiationRequest);

}
