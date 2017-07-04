import { Component, OnInit } from '@angular/core';
import {User} from '../user.model'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 
model = new User(0,"","");
//model = new User();
  constructor() { }

  ngOnInit() {
  }
get currentUser(){
  return JSON.stringify(this.model);
}
}
