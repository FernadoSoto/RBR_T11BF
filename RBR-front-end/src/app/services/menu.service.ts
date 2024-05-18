import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) {}

  getAllMenus() {
    return this.http.get('http://localhost:9000/api/menus');
  }

  getMenuById(id: number) {
    return this.http.get(`http://localhost:9000/api/menus/${id}`);
  }

  createMenu(menu: any) {
    return this.http.post('http://localhost:9000/api/menus', menu);
  }

  updateMenu(id: number, updatedMenu: any) {
    return this.http.put(`http://localhost:9000/api/menus/${id}`, updatedMenu);
  }

  deleteMenu(id: number) {
    return this.http.delete(`http://localhost:9000/api/menus/${id}`);
  }
}
