package s.p.r.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bookmodel {

    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;

    private String name;
    private String author;
    private String category;
    private String price;
    private String publisher;

    // --- Getters ---
    public int getBid() {
        return bid;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }
    public String getPrice() {
        return price;
    }
    public String getPublisher() {
        return publisher;
    }

    // --- Setters ---
    public void setBid(int bid) {
        this.bid = bid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher; // ✅ fixed
    }

   
    @Override
    public String toString() {
        return "Book [bid=" + bid + ", name=" + name + ", author=" + author +
               ", category=" + category + ", price=" + price + ", publisher=" + publisher + "]";
    }
}
	