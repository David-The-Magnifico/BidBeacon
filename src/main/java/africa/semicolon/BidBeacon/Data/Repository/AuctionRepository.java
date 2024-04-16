package africa.semicolon.BidBeacon.Data.Repository;

import africa.semicolon.BidBeacon.Data.Model.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface AuctionRepository  extends MongoRepository<Auction, String> {
    Collection<Auction> findAllActiveAuctions();
}
