package africa.semicolon.BidBeacon.DTOs.Request;

import lombok.Data;

@Data
public class BidRequest {
    private String itemId;
    private String bidderId;
    private double bidAmount;
}
