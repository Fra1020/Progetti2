import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  postFilm(data: any){
    return this.http.post<any>("http://localhost:3000/filmList/",data);
  }
  getFilm(){
    return this.http.get<any>("http://localhost:3000/filmList/");
  }
  putFilm(data:any,id: number){
    return this.http.put<any>("http://localhost:3000/filmList/"+id,data);
  }
  deleteFilm(id: number){
    return this.http.delete<any>("http://localhost:3000/filmList/"+id);
  }
}
