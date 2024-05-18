import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { TableService } from '../../services/table.service';

@Component({
  selector: 'app-table-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './table-form.component.html',
  styleUrl: './table-form.component.css'
})
export default class TableFormComponent {
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private tableService = inject(TableService);

    form = this.fb.group({
      tableNumber: ['', Validators.required],
      capacity: ['', Validators.required],
      status: ['FREE', Validators.required]
    });


  createTable() {
    const table = this.form.value;
    this.tableService.createTable(table)
    .subscribe(()=>{
      this.router.navigate(['/tableList']);
    });
  }
}
