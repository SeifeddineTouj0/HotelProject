import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RoomRoutingModule } from './room-routing.module';
import { RoomListComponent } from './components/room-list/room-list.component';
import { RoomDetailComponent } from './components/room-detail/room-detail.component';
import { RoomFormComponent } from './components/room-form/room-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ReservationFormComponent } from './components/reservation-form/reservation-form.component';
import { RoomListAdminComponent } from './components/room-list-admin/room-list-admin.component';
import { ReservationListComponent } from './components/reservation-list/reservation-list.component';


@NgModule({
  declarations: [
    RoomListComponent,
    RoomDetailComponent,
    RoomFormComponent,
    ReservationFormComponent,
    RoomListAdminComponent,
    ReservationListComponent
  ],
  imports: [
    CommonModule,
    RoomRoutingModule,
    ReactiveFormsModule
  ]
})
export class RoomModule { }
