package africa.semicolon.BidBeacon.DTOs.Request;

import lombok.Data;

@Data
public class PaymentRequest {
    private String buyerId;
    private String itemPurchasedId;
    private double paymentAmount;
}
