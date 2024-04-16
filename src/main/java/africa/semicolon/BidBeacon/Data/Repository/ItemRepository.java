package africa.semicolon.BidBeacon.Data.Repository;

import africa.semicolon.BidBeacon.Data.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ItemRepository extends MongoRepository<Item, String> {
}
