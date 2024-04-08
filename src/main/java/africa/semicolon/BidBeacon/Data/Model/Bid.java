package africa.semicolon.BidBeacon.Data.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Bid {
    @Id
    private int id;
    private Item item;
    private User bidder;
    private float amount;
    private Date timestamp;
}
