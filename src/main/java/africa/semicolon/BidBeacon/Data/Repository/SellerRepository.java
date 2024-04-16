package africa.semicolon.BidBeacon.Data.Repository;

import africa.semicolon.BidBeacon.Data.Model.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, String> {
}
