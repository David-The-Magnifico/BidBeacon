package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.DTOs.Request.LoginRequest;
import africa.semicolon.BidBeacon.DTOs.Request.LogoutRequest;
import africa.semicolon.BidBeacon.Data.Model.*;
import africa.semicolon.BidBeacon.Data.Repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuctionServiceTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private Buyer buyer;

    private Auction auction;

    @BeforeEach
    public void setUpAuction() {
        seller = new Buyer();
        auction = new Auction();
        auction.setId("1");
        auction.setTitle("Emperor Auction");
        auction.setDescription("This is an auction with high-value Antiques and artifacts");
        auction.setStartDate(LocalDateTime.now());
        auction.setEndDate(LocalDateTime.now().plusHours(1));
        auction.setStartingPrice(1000.0);
        auction.setSeller(seller);
    }

    @Test
    public void createAuction_shouldReturnAuction_whenValidInput() {
        Auction savedAuction = auctionService.createAuction(auction.getTitle(), auction.getDescription(),
                auction.getStartDate(), auction.getEndDate(), auction.getStartingPrice(), seller);
        assertNotNull(savedAuction);
        assertEquals(auction.getTitle(), savedAuction.getTitle());
        assertEquals(auction.getDescription(), savedAuction.getDescription());
        assertEquals(auction.getStartDate(), savedAuction.getStartDate());
        assertEquals(auction.getEndDate(), savedAuction.getEndDate());
        assertEquals(auction.getStartingPrice(), savedAuction.getStartingPrice());
        assertEquals(auction.getSeller(), savedAuction.getSeller());
    }

    @Test
    void createAuction_shouldThrowException_whenInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> auctionService.createAuction(null, "This is an auction with high-value Antiques and artifacts",
                auction.getStartDate(), auction.getEndDate(), 1000.0, seller));

        assertThrows(IllegalArgumentException.class, () -> auctionService.createAuction("", "This is an auction with high-value Antiques and artifacts",
                auction.getStartDate(), auction.getEndDate(), 1000.0, seller));

        assertThrows(IllegalArgumentException.class, () -> auctionService.createAuction("Emperor Auction", "This is an auction with high-value Antiques and artifacts",
                auction.getStartDate(), auction.getEndDate(), -1000.0, seller));

        assertThrows(IllegalArgumentException.class, () -> auctionService.createAuction("Emperor Auction", "This is an auction with high-value Antiques and artifacts",
                auction.getStartDate(), auction.getEndDate(), 1000.0, null));
    }

    @Test
    public void testToCloseAuction() {
        Auction auction = auctionService.closeAuction();
        auctionService.closeAuction();
        assertTrue(auction.isCloseAuction() == true);
    }

    @Test
    void testToGetAuctionById() {
        Auction savedAuction = auctionService.createAuction(auction.getTitle(), auction.getDescription(),
                auction.getStartDate(), auction.getEndDate(), auction.getStartingPrice(), seller);
        Auction retrievedAuction = auctionService.findAuctionById(savedAuction.getId());
        assertNotNull(retrievedAuction);
        assertEquals(savedAuction.getId(), retrievedAuction.getId());
    }

    @Test
    void testToPlaceBid() {
        Auction savedAuction = auctionService.createAuction(auction.getTitle(), auction.getDescription(),
                auction.getStartDate(), auction.getEndDate(), auction.getStartingPrice(), seller);
        double currentPrice = savedAuction.getCurrentHighestBid();
        double newBidAmount = currentPrice + 100.0;
        auctionService.placeBid(savedAuction.getId(), newBidAmount);
        assertEquals(newBidAmount, savedAuction.getCurrentHighestBid());
    }

    @Test
    void testToGetAllAuctions() {
        auctionService.createAuction("Auction 1", "Description 1", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 500.0, seller);
        auctionService.createAuction("Auction 2", "Description 2", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 750.0, seller);
        auctionService.createAuction("Auction 3", "Description 3", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 1000.0, seller);
        assertEquals(3, auctionService.findAllAuctions().size());
    }

    @Test
    public void testToLogin() {
        LoginRequest loginRequest = new LoginRequest();
        LoginRequest.setUsername("TheMagnifico");
        LoginRequest.setPassword("Kahuna2987");
        auctionService.login(loginRequest);
    }

@Test
public void testToLogout() {
    LogoutRequest logoutRequest = new LogoutRequest();
    LoginRequest loginRequest = new LoginRequest();
    LoginRequest.setUsername("TheMagnifico");
    LoginRequest.setPassword("Kahuna2987");
    assertTrue(UserService.login(loginRequest));
    assertTrue(UserService.logout());
}

    @Test
    public void testToViewItemsByCategory() {
        assertEquals(5, Item.FindItemsByCategory("Electronics").size());
    }

    @Test
    public void testViewItemInformation() {
        assertNotNull(Item.viewItemInformation("gold plated Edition No3."));
    }

    @Test
    public void testFindItemByName() {
        assertNotNull(Item.findItemByName("iPhone X"));
    }

    @Test
    public void testAddNewItemsByCategory() {
        assertTrue(Item.addNewItem("Blue Shirt", "Clothing", 29.99));
    }

    @Test
    public void testRemoveItemIfSoldOut() {
        assertTrue(Item.markItemAsSoldOut(12345));
    }

    @Test
    public void testUpdateItems() {
        assertTrue(Item.updateItemDetails(12345, "New Description", 39.99));
    }

    @Test
    public void testRemoveItemIfPaymentMade() {
        assertTrue(Item.removeItemIfPaymentMade(12345));
    }

    @Test
    public void testBidderWinningBid() {
        assertTrue(Auction.placeBid(12345, 50.0));
        assertTrue(Auction.closeAuction(12345));
        assertEquals("JohnDoe", Auction.currentHighestBid(12345));
    }
}