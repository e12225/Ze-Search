package search_Engine;

import org.json.simple.JSONArray;
import search_Engine.filters.OrganizationFilter;
import search_Engine.filters.TicketFilter;
import search_Engine.filters.UserFilter;

public class DataLoader {


    public JSONArray loadData(Object users, Object organizations, Object tickets, String category, String field, Object value)
    {
        JSONArray userJSON = (JSONArray) users;
        JSONArray orgJSON = (JSONArray) organizations;
        JSONArray ticketJSON = (JSONArray) tickets;

        JSONArray searchResults = new JSONArray();

        if (category.equalsIgnoreCase("Users"))
        {
            UserFilter userFilter = new UserFilter();
            searchResults = userFilter.getUsers(field, value, userJSON);
        }
        else if (category.equalsIgnoreCase("Organizations"))
        {
            OrganizationFilter organizationFilter = new OrganizationFilter();
            searchResults = organizationFilter.getOrganizations(field, value, orgJSON);
        }
        else
        {
            TicketFilter ticketFilter = new TicketFilter();
            searchResults = ticketFilter.getTickets(field, value, ticketJSON);
        }

        return searchResults;
    }
}
