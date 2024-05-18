import { PersonService } from './../../services/person.service';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-person-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './person-form.component.html',
  styleUrl: './person-form.component.css'
})
export default class PersonFormComponent {
  
    private fb = inject(FormBuilder);
    private router = inject(Router);
    private personService = inject(PersonService);

    form = this.fb.group({
      name: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      documentType: ['', [Validators.required]],
      documentNumber: ['', [Validators.required]],
      phone: [''],
    });

    create(){
      const person = this.form.value;
      this.personService.create(person)
      .subscribe(()=>{
        this.router.navigate(['/personList']);
      });
    }
}
