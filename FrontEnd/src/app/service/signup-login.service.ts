import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupLoginService {

  constructor(private http : HttpClient) { }


  userSignup(data:any)
  {
    const signupUrl = 'http://localhost:4444/foodieApp/user/register';
    return this.http.post<any>(signupUrl,data);
  }

  userLogin(data:any)
  {
    const loginUrl = 'http://localhost:4444/foodieApp/user/login';
    return this.http.post<any>(loginUrl,data);
  }
  
}
