package pe.edu.vg.app.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "Tables")
public class TableCL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TableID")
    private Long tableID;

    @Column(name = "TableNumber")
    private Long tableNumber;

    @Column(name = "Capacity")
    private Integer capacity;

    @Column(name = "Status", length = 8, columnDefinition = "NVARCHAR2(8) DEFAULT 'FREE'")
    private String status;
}
