import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared_service/user.service';
import { User } from '../../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  private user: User;

  constructor(private _service: UserService, private _router: Router) { }

  ngOnInit() {
    this.user = this._service.getter(); 
  }

  processForm() {
    if(this.user) {
      console.log(this.user);
    }
    else if (this.user.id == undefined) {
      console.log(this.user.id);
      this._service.createUsers(this.user).subscribe((user) => {
        this._router.navigate(['/']);
        console.log(this.user);
      },
      (error) => {
        console.log(error);
      });
    } else {
      this._service.updateUsers(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/']);
    },
      (error) => {
        console.log(error);
      });
    }
  }

}
