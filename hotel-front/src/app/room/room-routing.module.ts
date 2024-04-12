import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoomListComponent } from './components/room-list/room-list.component';
import { RoomFormComponent } from './components/room-form/room-form.component';

const routes: Routes = [
  {
    path:'',
    component: RoomListComponent
  },
  {
    path:'add',
    component:RoomFormComponent
  },
  {
    path:'edit/:id',
    component:RoomFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoomRoutingModule { }
