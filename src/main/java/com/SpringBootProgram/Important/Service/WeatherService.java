package com.SpringBootProgram.Important.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
//the api key if we put it in git hub everyone will see it
//so we actually put our api key in yml and use @Value(Path)


public class WeatherService {
    @Value("${weather.api.key}")
    private   String apiKey;//  apiKey:"acd2436d4b5403a2ec6b2bc8b3a16a8a"//apikey from weatherstacks
    //not put static bcz it will not work
    //we put it in browser with no stds (run on browser not chrome)

     private static final String API="https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

     @Autowired //this below help hitting api with code
     //till now we have done with browser and postman
     private RestTemplate restTemplate;//process stds request

    public String getWeather(String city){
         String finalAPI=API.replace("CITY",city).replace("API_KEY",apiKey);
         //we can send headers also
//        HttpHeaders httpHeaders=new HttpHeaders();
//        httpHeaders.set("key","value");

//         String requestBody="{\n" +
//                 "    \"userName\":\"Sunless\",\n" +
//                 "     \"password\":\"Lost\"\n" +
//
//         "}    ";
  // User user=User.builder().userName("Vipul").password("Vipul").build();//we can send this also in request body
      //  HttpEntity<String> httpEntity=new HttpEntity<>(requestBody);

        //the above is example of how to put Post in this we have used api key of an app
      return    restTemplate.exchange(finalAPI, HttpMethod.GET,null, String.class).getBody();//in last instead of String.class  we put WeatherResponse.class
        //for post call HttpMethod.Post
//        return    restTemplate.exchange(finalAPI, HttpMethod.POST,httpEntity, String.class).getBody();

    }

}
