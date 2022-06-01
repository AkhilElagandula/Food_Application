import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor( private http : HttpClient) { }

  
  getAllRestaurants()
  {
    const restauranturl = 'http://localhost:9090/foodieApp/restaurant/getRestaurant';
    return this.http.get<any>(restauranturl);
    // .pipe(map((res : any) => {
    //   return res;
    // }))
  }

  getRestaurantByLocation(location : string)
  {
    const locationUrl = 'http://localhost:9090/foodieApp/restaurant/restaurant-by-location/';
   return this.http.get<any>(locationUrl+location);
  }

  getAllCuisines()
  {
    const cuisineUrl = 'http://localhost:9090/foodieApp/cuisine/getAllCuisine';
    return this.http.get<any>(cuisineUrl);
  }

}
