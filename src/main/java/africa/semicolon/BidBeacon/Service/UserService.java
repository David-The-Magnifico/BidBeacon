package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.Data.Model.Buyer;

import java.util.Collection;

public interface UserService {

    Collection<Buyer> findAllUsers();
}
