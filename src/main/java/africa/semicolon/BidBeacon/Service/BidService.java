package africa.semicolon.BidBeacon.Service;


import africa.semicolon.BidBeacon.Data.Model.Auction;
import africa.semicolon.BidBeacon.Data.Model.Bid;

public interface BidService {

    boolean validateBid(Auction auction, Bid bid);
}
