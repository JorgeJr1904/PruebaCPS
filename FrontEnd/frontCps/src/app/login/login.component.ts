import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  responseData = {
    status: '',
    message: '',
    token: ''
  };

  constructor(private apiService: ApiService) { }

  Client = {
    email: "",
    password: ""
  }

  

  login(){
    this.apiService.postLogin(this.Client).subscribe(
      (data) => {
        this.responseData = data;
        if(this.responseData.message == "Login Correcto"){
          localStorage.setItem('token', this.responseData.token);
          window.location.href='/';
        }if(this.responseData.message == "Correo o Contrasenia Incorrectos"){
          alert(this.responseData.message);
        }
      },
      (error) => {
        console.error('Error al obtener datos:', error);
      }
    );
  }

}
