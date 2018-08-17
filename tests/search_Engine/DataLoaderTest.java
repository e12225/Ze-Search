package search_Engine;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;

public class DataLoaderTest {

    @Test
    public void loadData() throws Exception {

        System.out.println("============================= test session starts ==============================");

        DataLoader dataLoader = new DataLoader();
        JSONParser jsonParser = new JSONParser();

        Object usersObj = jsonParser.parse(new FileReader("C:\\Users\\DELL\\Desktop\\Australian Migration\\AFTER ARRIVAL\\Job Hunting\\Zendesk Coding Challenge\\Ze-Search\\tests\\search_Engine\\users_test.json"));
        Object orgsObj = jsonParser.parse(new FileReader("C:\\Users\\DELL\\Desktop\\Australian Migration\\AFTER ARRIVAL\\Job Hunting\\Zendesk Coding Challenge\\Ze-Search\\tests\\search_Engine\\organizations_test.json"));
        Object ticketsObj = jsonParser.parse(new FileReader("C:\\Users\\DELL\\Desktop\\Australian Migration\\AFTER ARRIVAL\\Job Hunting\\Zendesk Coding Challenge\\Ze-Search\\tests\\search_Engine\\tickets_test.json"));

        DataFilter dataFilter = new DataFilter();
        /**
         * Testing scenario for a 'user' object
         */
        String category_u = "Users";
        String field_u = "alias";
        String value_u = "Miss Coffey";

        JSONArray actualResults_u = dataLoader.loadData(usersObj, orgsObj, ticketsObj, category_u, field_u, value_u);
        JSONArray userJSON = (JSONArray) usersObj;
        JSONArray expectedResults_u = dataFilter.selectData(field_u, value_u, userJSON);
        Assert.assertEquals(expectedResults_u, actualResults_u);

        /**
         * Testing scenario for a 'ticket' object
         */
        String category_t = "Tickets";
        String field_t = "submitter_id";
        Integer value_t = 38;

        JSONArray actualResults_t = dataLoader.loadData(usersObj, orgsObj, ticketsObj, category_t, field_t, value_t);
        JSONArray ticketJSON = (JSONArray) ticketsObj;
        JSONArray expectedResults_t = dataFilter.selectData(field_t, value_t, ticketJSON);
        Assert.assertEquals(expectedResults_t, actualResults_t);

        /**
         * Testing scenario for an 'organization' object
         */
        String category_o = "Organizations";
        String field_o = "shared_tickets";
        boolean value_o = false;

        JSONArray actualResults_o = dataLoader.loadData(usersObj, orgsObj, ticketsObj, category_o, field_o, value_o);
        JSONArray orgJSON = (JSONArray) orgsObj;
        JSONArray expectedResults_o = dataFilter.selectData(field_o, value_o, orgJSON);
        Assert.assertEquals(expectedResults_o, actualResults_o);

        System.out.println("============================= test session ended ===============================");
    }
}