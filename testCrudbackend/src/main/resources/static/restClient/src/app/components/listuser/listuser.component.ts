import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared_service/user.service';
import { User } from '../../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {

  private users: User[];
  constructor(private _service: UserService, private _router: Router) { }

  ngOnInit() {
    this._service.getUsers().subscribe((users) => {
      console.log(users);
      this.users = users;
    },
    (error) => {
      console.log(error);
    })
  }

  updateUser(user) {
    this._service.setter(user);
    this._router.navigate(['/op']);
  }

  newUser() {
    let user = new User();
    this._service.setter(user);
    this._router.navigate(['/op']);

  }


  deleteUser(user) {

    this._service.deleteUser(user.id).subscribe((data) => {
      this.users.splice(this.users.indexOf(user), 1);
    },
    (error) => {
      console.log(error);
    })
  }

}
