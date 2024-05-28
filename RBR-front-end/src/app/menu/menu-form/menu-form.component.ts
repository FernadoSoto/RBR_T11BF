import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { MenuService } from '../../services/menu.service';
import { MenuCategoryService } from '../../services/menuctgry.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-menu-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './menu-form.component.html',
  styleUrls: ['./menu-form.component.css']
})
export default class MenuFormComponent implements OnInit {

  form!: FormGroup; 

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private menuService: MenuService,
    private menuCategoryService: MenuCategoryService
  ) {}

  categories: any[] = [];

  ngOnInit() {
    this.form = this.fb.group({
      dishName: ['', Validators.required],
      description: [''],
      price: ['', [Validators.required, Validators.pattern(/^\d*\.?\d{0,2}$/)]],
      status: ['active', Validators.required],
      categoryID: ['']
    });

    this.menuCategoryService.getAllMenuCategories()
      .subscribe((categories: any) => {
        this.categories = categories;
      });
  }

  createMenu() {
    if (this.form.invalid) {
      Swal.fire({
        title: "Campos incompletos",
        text: "Por favor, complete todos los campos antes de enviar el formulario.",
        icon: "error"
      });
      return;
    }

    const menu = this.form.value;
    this.menuService.createMenu(menu)
      .subscribe(() => {
        this.router.navigate(['/menuList']);
      });
  }
}