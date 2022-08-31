package org.svg.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class ElementTemplateHandler {

    public static JSONArray addOrUpdateArray(JSONArray jsonArray, int index, String templateName, String templateId, String appliesTo, StringBuilder sb, boolean templateMatch) {

        //Create new Object
        JSONObject updatedEntry = new JSONObject();
        updatedEntry.put("$schema", "https://unpkg.com/@camunda/zeebe-element-templates-json-schema/resources/schema.json");
        updatedEntry.put("name", templateName);
        updatedEntry.put("id", templateId);
        updatedEntry.put("description", templateName);
        updatedEntry.put("documentationRef", "https://docs.camunda.io");

        JSONArray appliesToArray = new JSONArray();
        appliesToArray.put(appliesTo);
        updatedEntry.put("appliesTo", appliesToArray);

        JSONObject value = new JSONObject();
        value.put("value", appliesTo);
        updatedEntry.put("elementType", value);

        JSONObject contents = new JSONObject();
        contents.put("contents", sb.toString());
        updatedEntry.put("icon", contents);

        JSONObject propertiesValues = new JSONObject();
        propertiesValues.put("type", "String");
        propertiesValues.put("value", templateName);

        JSONObject bindingsValues = new JSONObject();
        bindingsValues.put("type", "property");
        bindingsValues.put("name", "name");

        propertiesValues.put("binding", bindingsValues);

        JSONArray properties = new JSONArray();
        properties.put(propertiesValues);

        updatedEntry.put("properties", properties);

        //Put back or add into original array
        if(templateMatch) {
            jsonArray.put(index, updatedEntry);
        } else {
            jsonArray.put(updatedEntry);
        }

        return jsonArray;
    }
}
