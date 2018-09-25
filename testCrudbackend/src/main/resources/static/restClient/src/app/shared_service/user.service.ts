import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = "http://localhost:8080/api";
  private headers = new Headers({ 'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private user = new User();

  constructor(private _http: Http) { }

  getUsers() {
    return this._http.get(this.baseUrl + '/users', this.options).map((response: Response) => response.json())
    .catch(this.errorHanlder);
  }

  getUser(id:Number) {
    return this._http.get(this.baseUrl + '/users/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHanlder);
  }

  createUsers(user:User) {
    return this._http.post(this.baseUrl + '/users', JSON.stringify(user), this.options).map((response: Response) => response.json())
    .catch(this.errorHanlder);
  }
  

  updateUsers(user: User) {
    return this._http.put(this.baseUrl + '/users', JSON.stringify(user), this.options).map((response: Response) => response.json())
      .catch(this.errorHanlder);
  }

  deleteUser(id: Number) {
    return this._http.get(this.baseUrl + '/users/' + id, this.options).map((response: Response) => response.json())
    .catch(this.errorHanlder);
  }

  errorHanlder(error: Response) {
    return Observable.throw(error || "SERVER ERROR");
    
  }

  setter(user: User) {
    this.user = user;
  }

  getter() {
    return this.user;
  }

}
