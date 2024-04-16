package africa.semicolon.BidBeacon.Data.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Buyers")
public class Buyer {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String bid;
    private boolean paymentStatus;
    private List<Bid> biddingHistory;
}
