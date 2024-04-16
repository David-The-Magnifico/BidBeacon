package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.Data.Model.Auction;
import africa.semicolon.BidBeacon.Data.Model.Item;
import africa.semicolon.BidBeacon.Data.Model.Buyer;
import africa.semicolon.BidBeacon.Data.Repository.AuctionRepository;
import africa.semicolon.BidBeacon.Data.Repository.BuyerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private Item item;
    @Autowired
    private Buyer seller;
    @Autowired
    private Buyer buyer;
    @Autowired
    private Auction auction;

    @BeforeEach
    public void setUpItem() {
        seller = new Buyer();
        buyer = new Buyer();
        auction = new Auction();
        auction.setId("1");
        auction.setTitle("Emperor Auction");
        auction.setDescription("This is an auction with high-value Antiques and artifacts");
        auction.setStartDate(LocalDateTime.now());
        auction.setEndDate(LocalDateTime.now().plusHours(1));
        auction.setStartingPrice(1000.0);
        auction.setSeller(seller);
        item = new Item();
        item.setId("1");
        item.setTitle("Emperor Auction");
        item.setDescription("This is an auction with high-value Antiques and artifacts");
        item.setPrice(1000.0);
        item.setSeller(seller);
        item.setBuyer(buyer);
        item.setAuction(auction);
    }

    @Test
    public void findItem_whenIdExists_shouldReturnItem() {
        Item item = new Item("1", "Patek Calibre");
        Item foundItem = itemService.findItem("1");
        assertEquals(item, foundItem);
    }
