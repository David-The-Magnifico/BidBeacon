package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.DTOs.Request.LoginRequest;
import africa.semicolon.BidBeacon.Data.Model.Auction;
import africa.semicolon.BidBeacon.Data.Model.Item;
import africa.semicolon.BidBeacon.Data.Model.Buyer;

import java.time.LocalDateTime;
import java.util.Collection;

public interface AuctionService {
    Auction createAuction(String id, String title, LocalDateTime startDate,
                          LocalDateTime endDate, double startingPrice, Buyer seller);

    Auction closeAuction();

    public Auction findAuctionById(String id);

    void placeBid(String id, double newBidAmount);

    Collection<Auction> findAllAuctions();

    Collection<Buyer> findAllUsers();

    Collection<Item> findAllItems();

    Collection<Auction> findAllActiveAuctions();

    boolean login(String username, String password);

    void login(LoginRequest loginRequest);
}

