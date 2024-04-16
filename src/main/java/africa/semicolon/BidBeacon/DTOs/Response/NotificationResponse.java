package africa.semicolon.BidBeacon.DTOs.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {
    private String id;
    private String message;
    private String recipientId;
    private LocalDateTime timeSent;
}
