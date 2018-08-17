package search_Engine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DataFilter is used to retrieve the data, depending on the parameters(category, field, value) given by the user.
 */

public class DataFilter {

    public JSONArray selectData(String field, Object value, JSONArray categoryObjects)
    {
        JSONArray filteredData = new JSONArray();
        JSONObject categoryObject = null;

        int index = 0;
        while (categoryObjects.size() > index)
        {
            categoryObject = (JSONObject) categoryObjects.get(index);

            if (categoryObject.get(field) != null)
            {
                if (value.equals(categoryObject.get(field).toString()))
                {
                    filteredData.add(categoryObject);
                }
            }
            index++;
        }
        return filteredData;
    }
}
