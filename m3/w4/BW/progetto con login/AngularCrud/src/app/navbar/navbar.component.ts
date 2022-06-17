import { Component, OnInit } from '@angular/core';
import { AuthData, AuthService } from '../auth/auth.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  
  user!:AuthData|null

  constructor(private authSrv: AuthService) { }

  ngOnInit(): void {
    this.authSrv.loggedObs.subscribe((res)=>{
      this.user = res;
    })
  }

  
  

}
