import { Component, OnInit, inject } from '@angular/core';
import { MenuService } from '../../services/menu.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-menu-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './menu-list.component.html',
  styleUrl: './menu-list.component.css'
})
export default class MenuListComponent implements OnInit {
  private menuService = inject(MenuService);

  menus: any[] = [];

  ngOnInit(): void {
    this.menuService.getAllMenus()
      .subscribe((menus: any) => {
        this.menus = menus;
      });
  }
}
