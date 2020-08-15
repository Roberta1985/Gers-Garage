package ie.cct.gergarage.repository;

import ie.cct.gergarage.model.Item;
import org.springframework.data.repository.Repository;


import java.util.ArrayList;

public interface ItemRepository extends Repository<Item, Integer> {

    ArrayList<Item> findAll();
    Item save(Item item );
    void deleteByIdItem(Integer idItem);

}
