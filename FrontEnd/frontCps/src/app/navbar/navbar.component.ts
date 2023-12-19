import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  isLoggedIn(): boolean {
    if(localStorage.getItem("token") === null || localStorage.getItem("token") === ""){
        return false;
    }else{
      return true;
    }
  }

  logOut(event: MouseEvent){
    localStorage.clear();
    window.location.reload();
  }

}
