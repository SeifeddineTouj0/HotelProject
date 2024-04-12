import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RoomRoutingModule } from './room-routing.module';
import { RoomListComponent } from './components/room-list/room-list.component';
import { RoomDetailComponent } from './components/room-detail/room-detail.component';
import { RoomFormComponent } from './components/room-form/room-form.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    RoomListComponent,
    RoomDetailComponent,
    RoomFormComponent
  ],
  imports: [
    CommonModule,
    RoomRoutingModule,
    ReactiveFormsModule
  ]
})
export class RoomModule { }
