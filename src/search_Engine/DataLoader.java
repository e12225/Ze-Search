package search_Engine;

import org.json.simple.JSONArray;

public class DataLoader {

    public JSONArray loadData(Object users, Object organizations, Object tickets, String category, String field, Object value)
    {
        JSONArray userJSON = (JSONArray) users;
        JSONArray orgJSON = (JSONArray) organizations;
        JSONArray ticketJSON = (JSONArray) tickets;

        JSONArray searchResults = null;

        if (category != null && !category.isEmpty() && !((JSONArray) users).isEmpty() && !((JSONArray) organizations).isEmpty() && !((JSONArray) tickets).isEmpty())
        {
            DataFilter dataFilter = new DataFilter();

            if (category.equalsIgnoreCase("Users"))
            {
                searchResults = dataFilter.selectData(field, value, userJSON);
            }
            else if (category.equalsIgnoreCase("Organizations"))
            {
                searchResults = dataFilter.selectData(field, value, orgJSON);
            }
            else
            {
                searchResults = dataFilter.selectData(field, value, ticketJSON);
            }
        }

        return searchResults;
    }
}
