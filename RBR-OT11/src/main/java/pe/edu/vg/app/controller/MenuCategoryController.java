package pe.edu.vg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.vg.app.model.MenuCategory;
import pe.edu.vg.app.service.MenuCategoryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/menu-categories")
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
        return menuCategory.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
        MenuCategory createdMenuCategory = menuCategoryService.createMenuCategory(menuCategory);
        return new ResponseEntity<>(createdMenuCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable Long id, @RequestBody MenuCategory updatedMenuCategory) {
        MenuCategory menuCategory = menuCategoryService.updateMenuCategory(id, updatedMenuCategory);
        if (menuCategory != null) {
            return new ResponseEntity<>(menuCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuCategory(@PathVariable Long id) {
        boolean deleted = menuCategoryService.deleteMenuCategory(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
