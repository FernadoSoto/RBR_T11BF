import { Component, OnInit, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MenuCategoryService } from '../../services/menuctgry.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-menuctry-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './menuctry-list.component.html',
  styleUrl: './menuctry-list.component.css'
})
export default class MenuCategoryListComponent implements OnInit {
  constructor(private menuCategoryService: MenuCategoryService) {}

  categories: any[] = [];

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories() {
    this.menuCategoryService.getAllMenuCategories()
      .subscribe((categories: any) => {
        this.categories = categories;
      });
  }

  deleteCategory(category: any) {
    Swal.fire({
      title: '¿Está seguro?',
      text: '¿Está seguro de que desea eliminar esta categoría de menú?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        // Call the service to delete the category
        this.menuCategoryService.deleteMenuCategory(category.categoryID)
          .subscribe(() => {
            // Reload categories after successful deletion
            this.loadCategories();
            Swal.fire('¡Eliminado!', 'La categoría de menú ha sido eliminada correctamente.', 'success');
          }, error => {
            Swal.fire('¡Error!', 'Ocurrió un error al eliminar la categoría de menú.', 'error');
          });
      }
    });
  }
}
