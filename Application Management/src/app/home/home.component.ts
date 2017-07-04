import { Component, OnInit } from '@angular/core';
import { User } from "app/user.model";
import { FormBuilder, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

rForm: FormGroup;
post:any;
appid:string= '';
alert:string= 'This field is required';

  model = new User(0,"","");

  constructor(private fb: FormBuilder) {

    this.rForm = fb.group({

      'appid':[null, Validators.compose( [Validators.required,Validators.minLength(3),Validators.maxLength(5)])],

    });

   }

   addPost(post){
    this.appid=post.appid;
   }

  ngOnInit() {
  }
  
//get currentUser(){
//  return JSON.stringify(this.model);
//}


}
