package search_Engine.filters;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TicketFilter {

    public JSONArray getTickets(String field, Object value, JSONArray ticketJSON)
    {
        JSONArray filteredTickets = new JSONArray();
        JSONObject ticket = null;

        int i = 0;
        while (ticketJSON.size() > i)
        {
            ticket = (JSONObject) ticketJSON.get(i);
            if (value.equals(ticket.get(field)))
            {
                filteredTickets.add(ticket);
            }
            i++;
        }
        return filteredTickets;
    }
}
