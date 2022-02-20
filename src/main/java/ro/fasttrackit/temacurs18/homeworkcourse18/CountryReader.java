package ro.fasttrackit.temacurs18.homeworkcourse18;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
@Component
public class CountryReader {

    public static void main(String[] args) throws Exception {
        List<Country> countries = readCountry("file/countries2.txt");
        System.out.println(countries);
        readCountryFile();
        writeCountry(countries);
    }

    private static void readCountryFile() throws Exception {
        Scanner fileScanner = new Scanner(new File("file", "countries2.txt"));
        while (fileScanner.hasNext())
            System.out.println(fileScanner.nextLine());
    }

    private static void writeCountry(List<Country> countries) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file/countries2Beautiful.txt"))) {
            for (Country country : countries) {
                writer.write(countryToLine(country));
                writer.newLine();
            }
        }
    }

    private static String countryToLine(Country country) {
        return country.getId() + " " + country.getName() + " " + country.getCapital() + " " + country.getPopulation() + " " + country.getArea() + " " +
                country.getContinent() + " " + String.join(" ", country.getNeighbour());
    }

    private static List<Country> readCountry(String filePath) throws Exception {
        List<Country> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null) {
                id++;
                result.add(readCountriesFromLine(line, id));
            }
        }
        return result;
    }

    private static Country readCountriesFromLine(String line, int id) {
        String[] tokens = line.split(Pattern.quote("|"));
        List<String> neighbours;
        if (tokens.length == 5) {
            neighbours = new ArrayList<>();
        } else {
            String[] token = tokens[5].split(Pattern.quote("~"));
            neighbours = new ArrayList<>();
            for (String tok : token) {
                neighbours.add(tok);
            }
        }
            System.out.println(id);
            System.out.println(line);
            int[] array = new int[id];
            return new Country(id, tokens[0], tokens[1], Long.parseLong(tokens[2]), Long.parseLong(tokens[3]), tokens[4], neighbours);
    }
}
