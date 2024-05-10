package pe.edu.vg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.service.MenuCategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menucategories")
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @Autowired
    public MenuCategoryController(MenuCategoryService menuCategoryService) {
        this.menuCategoryService = menuCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<MenuCategory>> getAllMenuCategories() {
        List<MenuCategory> menuCategories = menuCategoryService.getAllMenuCategories();
        return new ResponseEntity<>(menuCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable Long id) {
        Optional<MenuCategory> menuCategory = menuCategoryService.getMenuCategoryById(id);
        return menuCategory.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
        MenuCategory createdMenuCategory = menuCategoryService.createMenuCategory(menuCategory);
        return new ResponseEntity<>(createdMenuCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable Long id, @RequestBody MenuCategory updatedMenuCategory) {
        MenuCategory updatedCategory = menuCategoryService.updateMenuCategory(id, updatedMenuCategory);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuCategory(@PathVariable Long id) {
        menuCategoryService.deleteMenuCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
