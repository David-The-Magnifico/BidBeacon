package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.Data.Model.Bid;
import africa.semicolon.BidBeacon.Exceptions.InvalidBidException;

public class BidServiceImpl implements BidService{
    @Override
    public void validateBid(Bid bid) {
        if (bid.getBidAmount() <= 0) {
            throw new InvalidBidException("Bid amount must be greater than zero");
        }
    }
    @Override
    public Bid saveBid(Bid bid) {
        return null;
    }
    @Override
    public Bid getBid(String bidId) {
        return null;
    }
    @Override
    public Bid updateBid(Bid bid) {
        return null;
    }
    @Override
    public Bid deleteBid(String bidId) {
        return null;
    }
    @Override
    public Iterable<Bid> getAllBids() {
        return Bid.getAllBids();
    }
}
