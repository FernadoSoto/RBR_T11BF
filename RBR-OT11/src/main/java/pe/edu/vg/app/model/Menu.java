package pe.edu.vg.app.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DishID")
    private Long dishID;

    @Column(name = "DishName")
    private String dishName;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "Price", precision = 8, scale = 2)
    private BigDecimal price;

    @Column(name = "Status", length = 8, columnDefinition = "NVARCHAR2(8) DEFAULT 'active'")
    private String status;

    @Column(name = "CategoryID")
    private Long categoryID;
}

