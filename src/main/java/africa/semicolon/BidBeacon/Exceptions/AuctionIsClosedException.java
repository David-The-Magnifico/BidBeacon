package africa.semicolon.BidBeacon.Exceptions;

public class AuctionIsClosedException extends RuntimeException {
    public AuctionIsClosedException(String message) {
        super(message);
    }
}
