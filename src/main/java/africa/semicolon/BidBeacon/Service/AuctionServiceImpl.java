package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.Data.Model.Auction;
import africa.semicolon.BidBeacon.Data.Model.Buyer;
import africa.semicolon.BidBeacon.Data.Model.Item;
import africa.semicolon.BidBeacon.Data.Repository.AuctionRepository;
import africa.semicolon.BidBeacon.Data.Repository.ItemRepository;
import africa.semicolon.BidBeacon.Data.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.BidBeacon.Exceptions.AuctionIsClosedException;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Auction createAuction(String id, String title, LocalDateTime startDate, LocalDateTime endDate, double startingPrice, Buyer seller) {
        Auction newAuction = new Auction(id, title, startDate, endDate, startingPrice, seller);
        return auctionRepository.save(newAuction);
    }

    @Override
    public Auction closeAuction() {
        return null;
    }

    @Override
    public Auction closeAuction(String auctionId) {
        Auction auction = auctionRepository.findAuctionById(auctionId);
        if (auction.getEndDate().isBefore(LocalDateTime.now())) {
            throw new AuctionIsClosedException("Auction is closed");
        }
        auction.isCloseAuction(true);
        return auctionRepository.save(auction);
    }

    @Override
    public Auction findAuctionById(String id) {
        return auctionRepository.findAuctionById(id);
    }

    @Override
    public void placeBid(String id, double newBidAmount) {

    }

    @Override
    public void placeBid(String auctionId, double newBidAmount, Buyer bidder) {
        Auction auction = auctionRepository.findAuctionById(auctionId);
        if (newBidAmount > auction.getCurrentHighestBid()){
            auction.setCurrentHighestBid(newBidAmount);
            auction.setCurrentHighestBid(bidder.getId());
            auctionRepository.save(auction);
        }
    }

    @Override
    public Collection<Auction> findAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Collection<Buyer> findAllUsers() {
        return userService.findAllUsers();
    }

    @Override
    public Collection<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Collection<Auction> findAllActiveAuctions() {
        return auctionRepository.findAllActiveAuctions();

    }

    @Override
    public boolean login(String username, String password) {
        Buyer buyer = buyerRepository.findByUsername(username);
        if (buyer != null && buyer.getPassword().equals(password)) {
            System.out.println("User logged in successfully");
        } else {
            System.out.println("Invalid username or password");
        }

        @Override
        public Auction findAuctionById(String id){
            return auctionRepository.findAuctionById(id);
        }

        private boolean highestBidderWins() {
            if (currentBid > startingPrice) {
                return true;
            } else {
                return false;
            }
        }
    }
}
