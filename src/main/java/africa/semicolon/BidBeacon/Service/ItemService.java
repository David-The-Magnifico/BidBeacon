package africa.semicolon.BidBeacon.Service;

import africa.semicolon.BidBeacon.Data.Model.Item;

import java.util.List;

public interface ItemService {
    Item findItem(String id);
    List<Item> findAllItems();
    void saveItem(Item item);
    void deleteItem(String id);
    void updateItem(String id, Item item);
    void deleteAllItems();
    void updateAllItems(List<Item> items);
    void deleteAllItemsByCategory(String category);
    void updateAllItemsByCategory(String category, List<Item> items);

}
