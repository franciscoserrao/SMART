package com.example.avjindersinghsekhon.minimaltodo.Utility;
import org.json.JSONException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.json.JSONArray;
import java.io.FileInputStream;
import org.json.JSONTokener;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import org.json.JSONObject;
import java.io.OutputStreamWriter;
import android.content.Context;
public class StoreRetrieveData {
    private android.content.Context mContext;

    private java.lang.String mFileName;

    public StoreRetrieveData(android.content.Context context, java.lang.String filename) {
        mContext = context;
        mFileName = filename;
    }


    public static org.json.JSONArray toJSONArray(java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items) throws org.json.JSONException {
        org.json.JSONArray jsonArray = new org.json.JSONArray();
        for (com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item : items) {
            org.json.JSONObject jsonObject = item.toJSON();
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }


    public void saveToFile(java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items) throws org.json.JSONException, java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        java.io.OutputStreamWriter outputStreamWriter;
        fileOutputStream = mContext.openFileOutput(mFileName, android.content.Context.MODE_PRIVATE);
        outputStreamWriter = new java.io.OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData.toJSONArray(items).toString());
        outputStreamWriter.close();
        fileOutputStream.close();
    }


    public java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> loadFromFile() throws java.io.IOException, org.json.JSONException {
        java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items = new java.util.ArrayList<>();
        java.io.BufferedReader bufferedReader = null;
        java.io.FileInputStream fileInputStream = null;
        try {
            fileInputStream = mContext.openFileInput(mFileName);
            java.lang.StringBuilder builder = new java.lang.StringBuilder();
            java.lang.String line;
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream));
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            } 
            org.json.JSONArray jsonArray = ((org.json.JSONArray) (new org.json.JSONTokener(builder.toString()).nextValue()));
            for (int i = 0; i < jsonArray.length(); i++) {
                com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item = new com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem(jsonArray.getJSONObject(i));
                items.add(item);
            }
        } catch (java.io.FileNotFoundException fnfe) {
            // do nothing about it
            // file won't exist first time app is run
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
        return items;
    }

}