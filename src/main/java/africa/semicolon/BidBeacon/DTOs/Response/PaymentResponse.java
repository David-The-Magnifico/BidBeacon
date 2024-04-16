package africa.semicolon.BidBeacon.DTOs.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private String paymentId;
    private String buyerId;
    private String itemPurchasedId;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private boolean isPaid;
}
