import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { MenuCategoryService } from '../../services/menuctgry.service';
@Component({
  selector: 'app-menuctry-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './menuctry-form.component.html',
  styleUrl: './menuctry-form.component.css'
})
export default class MenuCategoryFormComponent {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private menuCategoryService: MenuCategoryService
  ) {
    this.form = this.fb.group({
      categoryName: ['', Validators.required],
      status: ['active', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    if (this.form.valid) {
      const menuCategory = this.form.value;
      this.menuCategoryService.createMenuCategory(menuCategory)
        .subscribe(() => {
          this.router.navigate(['/menuCategoryList']);
        });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, complete todos los campos para enviar el formulario.'
      });
    }
  }
}
