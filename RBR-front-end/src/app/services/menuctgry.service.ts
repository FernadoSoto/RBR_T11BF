import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MenuCategoryService {

  constructor(private http: HttpClient) {}

  getAllMenuCategories() {
    return this.http.get('http://localhost:9000/api/menu-categories');
  }

  getMenuCategoryById(id: number) {
    return this.http.get(`http://localhost:9000/api/menu-categories/${id}`);
  }

  createMenuCategory(menuCategory: any) {
    return this.http.post('http://localhost:9000/api/menu-categories', menuCategory);
  }

  updateMenuCategory(id: number, updatedMenuCategory: any) {
    return this.http.put(`http://localhost:9000/api/menu-categories/${id}`, updatedMenuCategory);
  }

  deleteMenuCategory(id: number) {
    return this.http.delete(`http://localhost:9000/api/menu-categories/${id}`);
  }
}
