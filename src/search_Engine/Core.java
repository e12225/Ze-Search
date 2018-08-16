package search_Engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Core {

    public static void main(String[] args) {
        System.out.println("Welcome to Ze-Search Engine !!!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please specify the path to users.json data source");
        String users = scanner.nextLine();
        System.out.println("\nPlease specify the path to organizations.json data source");
        String organizations = scanner.nextLine();
        System.out.println("\nPlease specify the path to tickets.json data source");
        String tickets = scanner.nextLine();
        JSONParser jsonParser = new JSONParser();

        Object usersObj = null;
        Object orgsObj = null;
        Object ticketsObj = null;

        try {
            usersObj = jsonParser.parse(new FileReader(users));
            orgsObj = jsonParser.parse(new FileReader(organizations));
            ticketsObj = jsonParser.parse(new FileReader(tickets));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("\nPlease specify the category you want to search, from below choices :\n" +
                "  * Users\n" +
                "  * Organizations\n" +
                "  * Tickets");
        String category = scanner.nextLine();

        while (!category.equalsIgnoreCase("Users") && !category.equalsIgnoreCase("Organizations") && !category.equalsIgnoreCase("Tickets")) {

            System.out.println("\nWARNING: Please enter a valid category !");
            category = scanner.nextLine();
        }

        System.out.println("\nEnter the field name on which you want to search the " + category + " :");
        String field = scanner.nextLine();
        System.out.println("\nEnter the value of the field :");
        String value = scanner.nextLine();

        DataLoader dataLoader = new DataLoader();
        JSONArray results = dataLoader.loadData(usersObj, orgsObj, ticketsObj, category, field, value);
        if (results != null && !results.isEmpty()) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(results.toString());
            System.out.println(gson.toJson(je));
        } else {
            System.out.println("\nNo results found for the given parameters !");
        }

    }
}
