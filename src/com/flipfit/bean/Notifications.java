package com.flipfit.bean;

public class Notifications {
    String NotificationType;
    String NotificationTitle;
    String NotificationBody;

    public Notifications(String notificationType, String notificationTitle, String notificationBody) {
        NotificationType = notificationType;
        NotificationTitle = notificationTitle;
        NotificationBody = notificationBody;
    }

    public String getNotificationType() {
        return NotificationType;
    }

    public void setNotificationType(String notificationType) {
        NotificationType = notificationType;
    }

    public String getNotificationTitle() {
        return NotificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        NotificationTitle = notificationTitle;
    }

    public String getNotificationBody() {
        return NotificationBody;
    }

    public void setNotificationBody(String notificationBody) {
        NotificationBody = notificationBody;
    }
}
