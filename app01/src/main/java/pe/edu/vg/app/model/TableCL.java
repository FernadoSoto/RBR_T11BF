package pe.edu.vg.app.model;

import javax.persistence.*;

@Entity
@Table(name = "TABLES")
public class TableCL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long id;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

    // Constructor
    public TableCL() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "TableCL{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                '}';
    }
}
