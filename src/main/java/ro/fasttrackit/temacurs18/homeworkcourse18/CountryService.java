package ro.fasttrackit.temacurs18.homeworkcourse18;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CountryService  {

    List<Country> countries;
public CountryService(List<Country> countries){
        this.countries = countries == null
                ? new ArrayList<>()
                : new ArrayList<>(countries);
    }
    public List<Country> result() {
        countries.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result());
        return result();
    }
   public List<String> names() {
        countries.stream()
                .map(country -> country.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        return names();
    }
     public String getCapitals(int countryId,String capital){
        countries.stream()
                .map(country ->countryId + country.getCapital())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        return capital;
    }

    public Long getPopulation(int countryId, Long population) {
        countries.stream()
                .map(country -> countryId + country.getPopulation())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        return population;
    }
    public List<Country> item (String continentName,List<Country> countries){
        countries.stream()
                .map(country ->continentName + country.getContinent() + countries)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        return item(continentName,countries);
    }
}

