import { Component, OnInit, inject } from '@angular/core';
import { PersonService } from '../services/person.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-person-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './person-list.component.html',
  styleUrl: './person-list.component.css'
})
export default class PersonListComponent implements OnInit{
  private personService = inject(PersonService);

  persons: any[] = [];

  ngOnInit(): void {
    this.personService.list()
      .subscribe((persons: any)=>{
        this.persons = persons;
      })
  }

}
