// room-form.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Room } from '../../models/room';
import { RoomService } from '../../services/room.service';

@Component({
  selector: 'app-room-form',
  templateUrl: './room-form.component.html',
  styleUrls: ['./room-form.component.css']
})
export class RoomFormComponent implements OnInit {
  roomForm: FormGroup | undefined;
  roomId: string | null | undefined;
  isEdit: boolean = false;
  selectedFile: File | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private roomService: RoomService
  ) { }

  ngOnInit(): void {

    this.roomId = this.route.snapshot.paramMap.get('id');
    this.isEdit = !!this.route.snapshot.paramMap.get('id');
    this.initForm();
    if (this.isEdit) {
      this.roomService.getRoom(this.roomId).subscribe(room => {
        if (room) {
          this.roomForm?.patchValue(room);
        }
      });
    }
  }

  initForm(): void {
    this.roomForm = this.formBuilder.group({
      id: [''],
      view: ['', Validators.required],
      capacity: ['', Validators.required],
      price: ['', Validators.required],
      image: ['']
    });
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  onSubmit(): void {
    if (this.roomForm && this.roomForm.invalid) {
      return alert('Please fill all the required fields');
    }

    //const formData = this.roomForm?.value;
    const formData = new FormData();
    formData.append('view', this.roomForm?.get('view')?.value);
    formData.append('capacity', this.roomForm?.get('capacity')?.value);
    formData.append('price', this.roomForm?.get('price')?.value);
    if (this.selectedFile) {
      formData.append('image', this.selectedFile);
    }


    if (this.isEdit) {
      this.roomService.editRoom(formData).subscribe(() => {
        this.router.navigate(['/rooms']);
      });
    } else {
      console.log('formData', formData)
      this.roomService.addRoom(formData).subscribe(() => {
        this.router.navigate(['/rooms']);
      });
    }
  }
}
