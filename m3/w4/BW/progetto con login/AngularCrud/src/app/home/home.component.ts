import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private authSrv: AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  login(f:NgForm) {
    this.authSrv.login(f.value).subscribe((res)=>{
      console.log(res);
      this.router.navigate(['/users']);
    })

  }

  signup(f:NgForm){
    this.authSrv.signup(f.value).subscribe((res)=>{
      console.log(res);
      this.router.navigate(['/users']);
    })
    
  }

}
