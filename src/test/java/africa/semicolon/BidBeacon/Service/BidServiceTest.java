package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.Data.Model.Auction;
import africa.semicolon.BidBeacon.Data.Model.Bid;
import africa.semicolon.BidBeacon.Data.Model.Item;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BidServiceTest {
    @Test
    public void testBid() {
        BidService bidService = new BidService() {
            @Override
            public boolean validateBid(Auction auction, Bid bid) {
                return true;
            }
        };
        Auction auction = new Auction("Bugatti LaVoiture Noir", LocalDateTime.now(), "Sultan of Brunei");
        Bid bid = new Bid("Christiano Ronaldo", 15_000_000);
        assertTrue(bidService.validateBid(auction, bid));
    }
}
