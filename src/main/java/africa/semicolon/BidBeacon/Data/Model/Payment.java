package africa.semicolon.BidBeacon.Data.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Payments")
public class Payment {
    @Id
    private String paymentId;
    private Buyer bidder;
    private Item itemPurchased;
    private double PaymentAmount;
    private LocalDateTime paymentDate;
    private boolean isPaid;
}
