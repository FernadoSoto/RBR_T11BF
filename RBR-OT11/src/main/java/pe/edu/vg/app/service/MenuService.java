package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.vg.app.repository.MenuRepository;
import pe.edu.vg.app.model.Menu;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        if (menuRepository.existsById(id)) {
            updatedMenu.setDishID(id);
            return menuRepository.save(updatedMenu);
        } else {
            return null; // or throw an exception
        }
    }

    public boolean deleteMenu(Long id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

