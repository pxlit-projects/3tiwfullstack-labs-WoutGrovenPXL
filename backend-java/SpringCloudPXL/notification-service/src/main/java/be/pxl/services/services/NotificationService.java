package be.pxl.services.services;

import be.pxl.services.api.request.NotificationRequest;
import be.pxl.services.domain.Notification;
import be.pxl.services.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService implements INotificationService {

    private final NotificationRepository notificationRepository;


    @Override
    public void sendNotification(NotificationRequest notificiationRequest) {
        Notification notification = new Notification(
                notificiationRequest.from(),
                notificiationRequest.to(),
                notificiationRequest.subject(),
                notificiationRequest.message()
        );

        notificationRepository.save(notification);
    }
}
