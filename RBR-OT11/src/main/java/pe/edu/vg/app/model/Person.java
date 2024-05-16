package pe.edu.vg.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    private Long personID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "DocumentType", nullable = false)
    private String documentType;

    @Column(name = "DocumentNumber", nullable = false)
    private String documentNumber;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "Status", nullable = false, columnDefinition = "NVARCHAR2(8) DEFAULT 'active'")
    private String status;

    @Column(name = "Role", nullable = false)
    private String role;
}
