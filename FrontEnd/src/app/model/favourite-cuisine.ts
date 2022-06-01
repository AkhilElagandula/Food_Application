export class FavouriteCuisine 
{
    
    public cuisineId : number;
    public cuisineName : string;
    public cuisineImage : string;
    public emailId : string;

    constructor(cuisineId : number , cuisineName : string ,cuisineImage : string , emailId : string)
    {
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
        this.cuisineImage = cuisineImage;
        this.emailId = emailId;
    }
}
