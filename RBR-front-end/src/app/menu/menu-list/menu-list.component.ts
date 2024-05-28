import { Component, OnInit, inject } from '@angular/core';
import { MenuService } from '../../services/menu.service';
import { RouterModule } from '@angular/router';
import { MenuCategoryService } from '../../services/menuctgry.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-menu-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './menu-list.component.html',
  styleUrl: './menu-list.component.css'
})
export default class MenuListComponent implements OnInit {
  menus: any[] = [];
  categoriesMap: { [key: number]: string } = {};

  constructor(
    private menuService: MenuService,
    private menuCategoryService: MenuCategoryService
  ) {}

  ngOnInit(): void {
    // Fetch all menus
    this.menuService.getAllMenus().subscribe((menus: any) => {
      this.menus = menus;

      // Fetch all categories and create a map for quick lookup
      this.menuCategoryService.getAllMenuCategories().subscribe((categories: any) => {
        categories.forEach((category: any) => {
          this.categoriesMap[category.categoryID] = category.categoryName;
        });
      });
    });
  }

  getCategoryName(categoryID: number): string {
    // Return the category name corresponding to the categoryID
    return this.categoriesMap[categoryID] || 'Buscando Categoria';
  }

  confirmDelete(menu: any): void {
    Swal.fire({
      title: "¿Estás seguro?",
      text: "¡No podrás revertir esto!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Sí, eliminarlo"
    }).then((result) => {
      if (result.isConfirmed) {
        // Perform deletion action here, e.g., call a delete method from MenuService
        this.menuService.deleteMenu(menu.id).subscribe(() => {
          // Update menu list after deletion
          this.menuService.getAllMenus().subscribe((menus: any) => {
            this.menus = menus;
          });

          Swal.fire(
            "¡Eliminado!",
            "Tu menú ha sido eliminado.",
            "success"
          );
        });
      }
    });
  }
}