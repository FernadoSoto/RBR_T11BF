package pe.edu.vg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vg.app.model.TableCL;
import pe.edu.vg.app.service.TableCLService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
public class TableCLController {

    @Autowired
    private TableCLService tableCLService;

    @GetMapping
    public ResponseEntity<List<TableCL>> getAllTables() {
        List<TableCL> tables = tableCLService.getAllTables();
        return ResponseEntity.ok(tables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableCL> getTableById(@PathVariable Long id) {
        TableCL table = tableCLService.getTableById(id);
        if (table != null) {
            return ResponseEntity.ok(table);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TableCL> saveTable(@RequestBody TableCL tableCL) {
        TableCL savedTable = tableCLService.saveTable(tableCL);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable Long id) {
        tableCLService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status/{newStatus}")
    public ResponseEntity<?> updateTableStatus(@PathVariable Long id, @PathVariable String newStatus) {
        boolean updated = tableCLService.updateTableStatus(id, newStatus);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
