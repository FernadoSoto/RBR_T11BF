import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private http = inject(HttpClient);

  list( ){
    return this.http.get('http://localhost:9000/api/persons');
  }
  get(id: number){
    return this.http.get('http://localhost:9000/api/persons/${id}');
  }
  create(person: any){
    return this.http.post('http://localhost:9000/api/persons', person);
  }
  update(id: number, person: any){
    return this.http.put('http://localhost:9000/api/persons/${id}', person);
  }
  delete(id: number){
    return this.http.delete('http://localhost:9000/api/persons/${id}');
  }
}
