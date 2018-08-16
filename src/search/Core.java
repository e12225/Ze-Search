package search;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Core {

    public static void main(String[] args)
    {
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

        try
        {
            usersObj = jsonParser.parse(new FileReader(users));
            orgsObj = jsonParser.parse(new FileReader(organizations));
            ticketsObj = jsonParser.parse(new FileReader(tickets));

//            JSONArray userJSON = (JSONArray) usersObj;
//            JSONObject one = (JSONObject) userJSON.get(0);
//            String name = (String) one.get("");
//            System.out.println(name);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println("\nPlease specify the category you want to search :\n" +
                           "* Users\n" +
                           "* Organizations\n" +
                           "* Tickets");
        String category = scanner.nextLine();
        if ( !category.equalsIgnoreCase("Users") || !category.equalsIgnoreCase("Organizations") || !category.equalsIgnoreCase("Tickets"))
        {
            System.out.println("WARNING: Please enter a valid category number !");
        }
        else
        {
            System.out.println("\nEnter the field name on which you want to search the " + category);
            String field = scanner.nextLine();

            DataLoader dataLoader = new DataLoader();
            dataLoader.loadData(usersObj, orgsObj, ticketsObj, category, field);
        }
    }
}
