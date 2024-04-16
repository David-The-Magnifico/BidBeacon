package africa.semicolon.BidBeacon.Data.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentRepository, String> {
}
