package ie.cct.gergarage.controller;

import ie.cct.gergarage.model.Item;
import ie.cct.gergarage.model.Mech;
import ie.cct.gergarage.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RestController
@RequestMapping("/items")
public class ItemsController {


    @Autowired
    ItemRepository itemrepository;

    @Transactional
    @DeleteMapping("/delete-item")
    public void deleteItem(@RequestParam Integer idItem){

        itemrepository.deleteByIdItem(idItem);

    }

    @GetMapping("/all")
    public ArrayList<Item> allItems() {

        return itemrepository.findAll();


    }


    @PostMapping("/new")
    public void newItem(@RequestBody Item item) {

        itemrepository.save(item);

    }


    @PostMapping("/edit-price")
    public void editPrice(@RequestBody Item item) {

        itemrepository.save(item);

    }

}
