package africa.semicolon.BidBeacon.DTOs.Request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemRequest {
    private String name;
    private String description;
    private String category;
    private double startingPrice;
    private LocalDateTime auctionEndTime;
}
