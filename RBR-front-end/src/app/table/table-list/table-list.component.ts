import { Component, OnInit, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TableService } from '../../services/table.service';

@Component({
  selector: 'app-table-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './table-list.component.html',
  styleUrl: './table-list.component.css'
})
export default class TableListComponent implements OnInit {
  private tableService = inject(TableService);
  tables: any[] = [];

  ngOnInit(): void {
    this.tableService.getAllTables()
      .subscribe((tables: any) => {
        this.tables = tables;
      });
  }
}
