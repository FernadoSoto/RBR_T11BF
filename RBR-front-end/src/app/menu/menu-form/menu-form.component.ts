import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { MenuService } from '../../services/menu.service';

@Component({
  selector: 'app-menu-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './menu-form.component.html',
  styleUrl: './menu-form.component.css'
})
export default class MenuFormComponent {

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private menuService = inject(MenuService);

    form = this.fb.group({
      dishName: ['', Validators.required],
      description: [''],
      price: ['', [Validators.required, Validators.pattern(/^\d*\.?\d{0,2}$/)]],
      status: ['active', Validators.required],
      categoryID: [''] 
    });

  createMenu() {
      const menu = this.form.value;
      this.menuService.createMenu(menu)
      .subscribe(() => {
        this.router.navigate(['/menuList']);
      });
  }
}
