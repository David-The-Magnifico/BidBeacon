package africa.semicolon.BidBeacon.Data.Model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Items")
public class Item {
    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private double startingPrice;
    private double currentHighestBid;
    private Buyer seller;
    private LocalDateTime auctionEndTime;

}
