import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { NgModule } from '@angular/core';
import { StudentComponent } from './student/student/student.component';
import { NastavnikComponent } from './nastavnik/nastavnik/nastavnik.component';
import { PrijavaComponent } from './prijava/prijava/prijava.component';


export const routes: Routes = [
    {path:'',redirectTo:'login',pathMatch:'full'},
    { path: 'login', component: LoginComponent },
    { path: "student", component: StudentComponent },
    { path: "nastavnik", component: NastavnikComponent },
    { path: "prijava", component: PrijavaComponent }
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})


export class AppRoutes { }