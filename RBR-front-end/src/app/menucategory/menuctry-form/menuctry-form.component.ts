import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { MenuCategoryService } from '../../services/menuctgry.service';
@Component({
  selector: 'app-menuctry-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './menuctry-form.component.html',
  styleUrl: './menuctry-form.component.css'
})
export default class MenuCategoryFormComponent {

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private menuCategoryService = inject(MenuCategoryService);

    form = this.fb.group({
      categoryName: ['', Validators.required],
      status: ['active', Validators.required]
    });


  createMenuCategory() {
    const menuCategory = this.form.value;
    this.menuCategoryService.createMenuCategory(menuCategory)
      .subscribe(() => {
        this.router.navigate(['/menuCategoryList']);
      });
  }
}
