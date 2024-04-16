package africa.semicolon.BidBeacon.DTOs.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemResponse {
    private String id;
    private String name;
    private String description;
    private String category;
    private double startingPrice;
    private double currentHighestBid;
    private String sellerId;
    private LocalDateTime auctionEndTime;
}
