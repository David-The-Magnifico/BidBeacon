package africa.semicolon.BidBeacon.Data.Repository;


import africa.semicolon.BidBeacon.Data.Model.Buyer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuyerRepository extends MongoRepository<Buyer, String> {
}
