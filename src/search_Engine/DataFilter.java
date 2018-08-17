package search_Engine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataFilter {

    public JSONArray selectData(String field, Object value, JSONArray categoryObjects)
    {
        JSONArray filteredData = new JSONArray();
        JSONObject categoryObject = null;

        int i = 0;
        while (categoryObjects.size() > i)
        {
            categoryObject = (JSONObject) categoryObjects.get(i);

            if (categoryObject.get(field) != null)
            {
                if (value.equals(categoryObject.get(field).toString()))
                {
                    filteredData.add(categoryObject);
                }
            }
            i++;
        }
        return filteredData;
    }
}
