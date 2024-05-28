import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { PersonService } from './../../services/person.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-person-edit',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './person-edit.component.html',
  styleUrl: './person-edit.component.css'
})
export default class PersonEditComponent implements OnInit {
  personId: number = 0; 
  person: any;

  form = this.fb.group({
    name: ['', [Validators.required]],
    lastName: ['', [Validators.required]],
    documentType: ['', [Validators.required]],
    documentNumber: ['', [Validators.required]],
    phone: ['', [Validators.required]],
    status: ['active', [Validators.required]],
    role: ['', [Validators.required]]
  });

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private personService: PersonService
  ) { }

  ngOnInit(): void {
    this.personId = this.route.snapshot.params['id'];
    this.loadPerson(this.personId);
  }

  loadPerson(id: number): void {
    this.personService.get(id)
      .subscribe((data: any) => {
        this.person = data;
        this.form.patchValue(this.person);
      });
  }

  update(): void {
    if (this.form.valid) {
      const updatedPerson = this.form.value;
      this.personService.update(this.personId, updatedPerson)
        .subscribe(() => {
          Swal.fire({
            icon: 'success',
            title: 'Éxito',
            text: '¡Persona actualizada exitosamente!'
          }).then(() => {
            this.router.navigate(['/personList']);
          });
        });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, completa todos los campos obligatorios.'
      });
    }
  }

  toggleStatus(): void {
    const statusControl = this.form.get('status');
    if (statusControl) {
      const newStatus = statusControl.value === 'active' ? 'inactive' : 'active';
      statusControl.setValue(newStatus);
    }
  }
}