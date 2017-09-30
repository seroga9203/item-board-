package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ib_items")
public class Item implements Serializable {

    @Id
    private int id;
    private String name;
    private String pic;
    private String cat;
    private int price;
    private String about;
    private Date date;
    private String city;
    private String phone;
    private String owner;
    private int isTop;

    public Item() {
    }

    public Item(int id,
            String name,
            String pic,
            String cat,
            int price,
            String about,
            Date date,
            String city,
            String phone,
            String owner,
            int isTop) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.cat = cat;
        this.price = price;
        this.about = about;
        this.date = date;
        this.city = city;
        this.phone = phone;
        this.owner = owner;
        this.isTop = isTop;
    }

    public int isIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.pic);
        hash = 31 * hash + Objects.hashCode(this.cat);
        hash = 31 * hash + this.price;
        hash = 31 * hash + Objects.hashCode(this.about);
        hash = 31 * hash + Objects.hashCode(this.date);
        hash = 31 * hash + Objects.hashCode(this.city);
        hash = 31 * hash + Objects.hashCode(this.phone);
        hash = 31 * hash + Objects.hashCode(this.owner);
        hash = 31 * hash + this.isTop;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.isTop != other.isTop) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pic, other.pic)) {
            return false;
        }
        if (!Objects.equals(this.cat, other.cat)) {
            return false;
        }
        if (!Objects.equals(this.about, other.about)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", pic=" + pic + ", cat=" + cat + ", price=" + price + ", about=" + about + ", date=" + date + ", city=" + city + ", phone=" + phone + ", owner=" + owner + ", isTop=" + isTop + '}';
    }

}
