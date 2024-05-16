package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.repository.MenuCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;

    @Autowired
    public MenuCategoryService(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }

    public Optional<MenuCategory> getMenuCategoryById(Long id) {
        return menuCategoryRepository.findById(id);
    }

    public MenuCategory createMenuCategory(MenuCategory menuCategory) {
        return menuCategoryRepository.save(menuCategory);
    }

    public MenuCategory updateMenuCategory(Long id, MenuCategory updatedMenuCategory) {
        if (menuCategoryRepository.existsById(id)) {
            updatedMenuCategory.setCategoryID(id);
            return menuCategoryRepository.save(updatedMenuCategory);
        } else {
            return null; // or throw an exception
        }
    }

    public boolean deleteMenuCategory(Long id) {
        if (menuCategoryRepository.existsById(id)) {
            menuCategoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
