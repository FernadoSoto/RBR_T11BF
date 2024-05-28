import { Component, OnInit, inject } from '@angular/core';
import { PersonService } from '../../services/person.service';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-person-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './person-list.component.html',
  styleUrl: './person-list.component.css'
})
export default class PersonListComponent implements OnInit{
  constructor(private personService: PersonService) {}

  persons: any[] = [];

  ngOnInit(): void {
    this.loadPersons();
  }

  loadPersons() {
    this.personService.list()
      .subscribe((persons: any) => {
        this.persons = persons;
      });
  }

  confirmDelete(personId: number) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: '¡No podrás revertir esto!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí, borrarlo'
    }).then((result) => {
      if (result.isConfirmed) {
        this.deletePerson(personId);
      }
    });
  }

  deletePerson(personId: number) {
    this.personService.delete(personId)
      .subscribe(() => {
        this.loadPersons();
        Swal.fire(
          '¡Borrado!',
          '¡Tu registro ha sido eliminado.',
          'success'
        );
      });
  }

  trackByFn(index: number, item: any) {
    return item.id;
  }
}
