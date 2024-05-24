import { Component, OnInit, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MenuCategoryService } from '../../services/menuctgry.service';

@Component({
  selector: 'app-menuctry-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './menuctry-list.component.html',
  styleUrl: './menuctry-list.component.css'
})
export default class MenuCategoryListComponent implements OnInit {
  private menuCategoryService = inject(MenuCategoryService);

  categories: any[] = [];

  ngOnInit(): void {
    this.menuCategoryService.getAllMenuCategories()
      .subscribe((categories: any) => {
        this.categories = categories;
      });
  }
}
