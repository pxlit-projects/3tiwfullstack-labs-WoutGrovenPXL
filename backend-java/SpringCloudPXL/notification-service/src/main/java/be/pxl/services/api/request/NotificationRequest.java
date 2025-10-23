package be.pxl.services.api.request;

public record NotificationRequest(String from, String to, String subject, String message) {
}
