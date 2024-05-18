import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TableService } from '../../services/table.service';

@Component({
  selector: 'app-table-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './table-list.component.html',
  styleUrl: './table-list.component.css'
})
export class TableListComponent implements OnInit {
  tables: any[] = [];

  constructor(private tableService: TableService) {}

  ngOnInit(): void {
    this.tableService.getAllTables()
      .subscribe((tables: any) => {
        this.tables = tables;
      });
  }
}
