package africa.semicolon.BidBeacon.Data.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Sellers")
public class Seller {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String sell;
    private boolean paymentStatus;
    private List<Bid> biddingHistory;
}