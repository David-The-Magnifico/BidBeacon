package africa.semicolon.BidBeacon.Data.Repository;

import africa.semicolon.BidBeacon.Data.Model.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidRepository extends MongoRepository<Bid, String> {

}
