package ro.fasttrackit.temacurs18.homeworkcourse18;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController extends CountryService{

    public CountryController(List<Country> countries) {
        super(countries);
    }
   @GetMapping
    List<Country> getCountries(){
        return result();
    }
    @GetMapping("names")
    List<String> getCountriesNames(){
        return names();
    }
    @GetMapping("/capital/{countryId}")
    String capitals(){
        return getCapitals(0, "");
    }
    @GetMapping("/population{countryId}")
    Long population(){
        return getPopulation(0, population().longValue());
    }
    @GetMapping("/continents/{continentName}/countries")
    List<Country> getContinent(){
        return item(" ",  countries);
    }
}

