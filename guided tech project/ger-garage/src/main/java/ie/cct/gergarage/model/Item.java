package ie.cct.gergarage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "idsup")

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItem;

    @Column(name = "nameitem")
    private String nameitem;

    @Column(name = "price")
    private Double price;

    public Item() {
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
