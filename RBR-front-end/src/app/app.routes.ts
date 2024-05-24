import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path:'personList',
        loadComponent: () => import('./person/person-list/person-list.component')
    },
    {
        path:'newPerson',
        loadComponent: () => import('./person/person-form/person-form.component')
    },
    {
        path:'menuList',
        loadComponent: () => import('./menu/menu-list/menu-list.component')
    },  
    {
        path:'menuForm',
        loadComponent: () => import('./menu/menu-form/menu-form.component')
    }, 
    {
        path:'tableList',
        loadComponent: () => import('./table/table-list/table-list.component')
    },
    {
        path:'tableForm',
        loadComponent: () =>import('./table/table-form/table-form.component')
    },
    {
        path: 'menuCategoryList',
        loadComponent: () => import('./menucategory/menuctry-list/menuctry-list.component')
    },
    {
        path: 'menuCategoryForm',
        loadComponent: () => import('./menucategory/menuctry-form/menuctry-form.component')
    },
];
