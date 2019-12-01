run from Weather.class main()

it will have function call:

1.  WeatherGet.GetCurrentWeatherUpdate(APIKey);

 it will return
 code : US
 city : Long Island City
 cityId : 5125125


2. WeatherGet.GetThreeHourWeatherUpdate(APIKey, zip, Country);
 it will return:
    timezone : 39600
    weather : [{"icon":"04d","description":"overcast clouds","main":"Clouds","id":804}]

3. two results will in folder after run:
GetCurrentWeather.json
GetThreeHoursWeather.json