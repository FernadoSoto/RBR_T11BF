package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.vg.app.model.TableCL;
import pe.edu.vg.app.repository.TableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<TableCL> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<TableCL> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    public TableCL createTable(TableCL table) {
        return tableRepository.save(table);
    }

    public TableCL updateTable(Long id, TableCL updatedTable) {
        if (tableRepository.existsById(id)) {
            updatedTable.setTableID(id);
            return tableRepository.save(updatedTable);
        } else {
            return null; // or throw an exception
        }
    }

    public boolean deleteTable(Long id) {
        if (tableRepository.existsById(id)) {
            tableRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
