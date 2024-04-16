package africa.semicolon.BidBeacon.DTOs.Request;

import java.time.LocalDateTime;

public class CreateAuctionRequest {
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double startingPrice;
    private String seller;
}
