package ro.fasttrackit.temacurs18.homeworkcourse18;

import java.util.List;
import java.util.Objects;

public class Country {
    private final int id;
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final String continent;
    private final List<String> neighbour;


    public Country(int id, String name,String capital,long population,long area, String continent,List<String> neighbour){
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbour = neighbour;



    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCapital() {
        return capital;
    }
    public double getPopulation() {
        return population;
    }
    public double getArea() {
        return area;
    }
    public String getContinent() {
        return continent;
    }
    public List<String> getNeighbour() {
        return neighbour;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && population == country.population && area == country.area && Objects.equals(name, country.name) && Objects.equals(capital, country.capital) && Objects.equals(continent, country.continent) && Objects.equals(neighbour, country.neighbour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capital, population, area, continent, neighbour);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbour=" + neighbour +
                '}';
    }
}

