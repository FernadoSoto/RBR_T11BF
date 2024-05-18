import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TableService } from '../../services/table.service';

@Component({
  selector: 'app-table-form',
  standalone: true,
  imports: [],
  templateUrl: './table-form.component.html',
  styleUrl: './table-form.component.css'
})
export class TableFormComponent {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private tableService: TableService
  ) {
    this.form = this.formBuilder.group({
      tableNumber: ['', Validators.required],
      capacity: ['', Validators.required],
      status: ['FREE', Validators.required]
    });
  }

  createTable() {
    if (this.form.valid) {
      this.tableService.createTable(this.form.value)
        .subscribe(() => {
          this.router.navigate(['/tableList']);
        });
    }
  }
}
