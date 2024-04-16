package africa.semicolon.BidBeacon.DTOs.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BidResponse {
    private String itemId;
    private String bidderId;
    private double bidAmount;
    private LocalDateTime timeOfBid;
}