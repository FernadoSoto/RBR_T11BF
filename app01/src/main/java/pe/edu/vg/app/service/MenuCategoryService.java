package pe.edu.vg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.repository.MenuCategoryRepository;

import java.util.List;

@Service
public class MenuCategoryService {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }

    public MenuCategory getMenuCategoryById(Long id) {
        return menuCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Menu category not found with id " + id));
    }

    public MenuCategory createMenuCategory(MenuCategory menuCategory) {
        return menuCategoryRepository.save(menuCategory);
    }

    public MenuCategory updateMenuCategory(Long id, MenuCategory menuCategoryDetails) {
        MenuCategory menuCategory = getMenuCategoryById(id);

        menuCategory.setName(menuCategoryDetails.getName());
        menuCategory.setStatus(menuCategoryDetails.getStatus());

        return menuCategoryRepository.save(menuCategory);
    }

    public void deleteMenuCategory(Long id) {
        menuCategoryRepository.deleteById(id);
    }
}
