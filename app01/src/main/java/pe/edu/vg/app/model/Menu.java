package pe.edu.vg.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "MENU")
public class Menu {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long id;

    @Column(name = "dish_name")
    private String name;

    @Column(name = "description", columnDefinition = "CLOB")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String status = "active";

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MenuCategory category;

    // Constructor
    public Menu() {
    }

    // toString method
    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", category=" + category +
                '}';
    }
}
