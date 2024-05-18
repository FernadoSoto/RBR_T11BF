import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TableService {

  constructor(private http: HttpClient) {}

  getAllTables() {
    return this.http.get('http://localhost:9000/api/tables');
  }

  getTableById(id: number) {
    return this.http.get(`http://localhost:9000/api/tables/${id}`);
  }

  createTable(table: any) {
    return this.http.post('http://localhost:9000/api/tables', table);
  }

  updateTable(id: number, updatedTable: any) {
    return this.http.put(`http://localhost:9000/api/tables/${id}`, updatedTable);
  }

  deleteTable(id: number) {
    return this.http.delete(`http://localhost:9000/api/tables/${id}`);
  }
}
