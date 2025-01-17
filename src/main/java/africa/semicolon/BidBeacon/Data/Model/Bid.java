package africa.semicolon.BidBeacon.Data.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Bid {
    @Id
    private String id;
    private Item item;
    private Buyer bidder;
    private double bidAmount;
    private double currentPrice;
    private LocalDateTime timeOfBid;
}
