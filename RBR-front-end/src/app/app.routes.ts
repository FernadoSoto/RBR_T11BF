import { Component } from '@angular/core';
import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path:'',
        loadComponent: () => import('./person-list/person-list.component')
    },

    {
        path:'new',
        loadComponent: () => import('./person-form/person-form.component')
    }

];
