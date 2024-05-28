import { PersonService } from './../../services/person.service';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-person-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './person-form.component.html',
  styleUrl: './person-form.component.css'
})
export default class PersonFormComponent {
  
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private personService: PersonService
  ) {}

  form = this.fb.group({
    name: ['', [Validators.required]],
    lastName: ['', [Validators.required]],
    documentType: ['', [Validators.required]],
    documentNumber: ['', [Validators.required]],
    phone: ['', [Validators.required]],
    status: ['active', [Validators.required]],
    role: ['', [Validators.required]]
  });

  create() {
    if (this.form.valid) {
      const person = this.form.value;
      this.personService.create(person)
        .subscribe(() => {
          this.router.navigate(['/personList']);
        });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, completa todos los campos obligatorios.',
      });
    }
  }
}