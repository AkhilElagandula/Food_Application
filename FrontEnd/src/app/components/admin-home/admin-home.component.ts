import { Component, OnInit } from '@angular/core';
import { FormArray, FormGroup, FormControl } from '@angular/forms';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { AdminService } from './../../service/admin.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {


  constructor(
    private restaurantService: RestaurantService,
    private adminService : AdminService
  ) { }

  public allRestaurants: any;
  totalRecords: string;
  totalRecordsByLocation: string;
  page: number = 1;

  public viewAllRestaurants: boolean = true;
  public viewAddRestaurants: boolean = false;

  

  ngOnInit(): void {

    this.foodieRestaurants();
  
  }

 
     restaurantForm = new FormGroup({
      restaurantId : new FormControl(''),
      restaurantName : new FormControl(''),
      location : new FormControl(''),
      rating : new FormControl(''),
      cuisine : new FormGroup({
         cuisineName : new FormControl('') 
       })
    });

    saveRestaurant() {
      const restaurant = this.restaurantForm.value;
      this.adminService.addRestaurants(this.restaurantForm.value);
      console.log(restaurant);
    }
 

  addCuisine()
  {
    const item = <FormArray>this.restaurantForm.controls['cuisine'];
    item.push(
      new FormGroup({
        cuisineName : new FormControl('') 
      })
    );
  }

  removeCuisine(index : any)
  {
    const item = <FormArray>this.restaurantForm.controls['cuisine'];
    item.removeAt(index);
  }

  // saveRestaurant()
  // {
  //   const restaurant = this.restaurantForm.value;
  //   console.log(restaurant);
  // }


  foodieRestaurants() {
    this.restaurantService.getAllRestaurants()
      .subscribe((res) => {
        this.allRestaurants = res;
        this.totalRecords = res.length

        console.log(this.totalRecords)
      },
        error => {
          console.log(error);
        })
  }

  openForm() {
    this.viewAddRestaurants = true;
    this.viewAllRestaurants = false;
  }

  onSubmit()
  {
    console.log(this.restaurantForm.value);
  }

}

