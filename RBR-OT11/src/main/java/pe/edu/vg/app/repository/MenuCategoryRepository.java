package pe.edu.vg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.vg.app.model.MenuCategory;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
    // Puedes agregar métodos de consulta adicionales según tus necesidades
}


