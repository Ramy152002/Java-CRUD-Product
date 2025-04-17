package ERP.Project.Spring.Boot.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name="PRICE")
    private Double price;



    public Product(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Default constructor (required by Hibernate)
    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
