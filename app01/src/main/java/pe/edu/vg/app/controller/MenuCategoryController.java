package pe.edu.vg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.service.MenuCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu-categories")
public class MenuCategoryController {

    @Autowired
    private MenuCategoryService menuCategoryService;

    @GetMapping
    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryService.getAllMenuCategories();
    }

    @GetMapping("/{id}")
    public MenuCategory getMenuCategoryById(@PathVariable Long id) {
        return menuCategoryService.getMenuCategoryById(id);
    }

    @PostMapping
    public MenuCategory createMenuCategory(@RequestBody MenuCategory menuCategory) {
        return menuCategoryService.createMenuCategory(menuCategory);
    }

    @PutMapping("/{id}")
    public MenuCategory updateMenuCategory(@PathVariable Long id, @RequestBody MenuCategory menuCategoryDetails) {
        return menuCategoryService.updateMenuCategory(id, menuCategoryDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuCategory(@PathVariable Long id) {
        menuCategoryService.deleteMenuCategory(id);
    }
}
