package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vg.app.model.TableCL;
import pe.edu.vg.app.repository.TableCLRepository;

import java.util.List;

@Service
public class TableCLService {

    @Autowired
    private TableCLRepository tableCLRepository;

    public List<TableCL> getAllTables() {
        return tableCLRepository.findAll();
    }

    public TableCL getTableById(Long id) {
        return tableCLRepository.findById(id).orElse(null);
    }

    public TableCL saveTable(TableCL tableCL) {
        return tableCLRepository.save(tableCL);
    }

    public void deleteTable(Long id) {
        tableCLRepository.deleteById(id);
    }

    public boolean updateTableStatus(Long id, String newStatus) {
        TableCL tableCL = tableCLRepository.findById(id).orElse(null);
        if (tableCL != null) {
            tableCL.setStatus(newStatus);
            tableCLRepository.save(tableCL);
            return true;
        }
        return false;
    }
}
