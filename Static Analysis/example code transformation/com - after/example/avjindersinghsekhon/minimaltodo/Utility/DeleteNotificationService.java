package com.example.avjindersinghsekhon.minimaltodo.Utility;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment;
import android.app.IntentService;
import android.content.SharedPreferences;
import java.util.ArrayList;
import android.content.Intent;
import java.util.UUID;
public class DeleteNotificationService extends android.app.IntentService {
    private com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData storeRetrieveData;

    private java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> mToDoItems;

    private com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem mItem;

    public DeleteNotificationService() {
        super("DeleteNotificationService");
    }


    @java.lang.Override
    protected void onHandleIntent(android.content.Intent intent) {
        storeRetrieveData = new com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData(this, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.FILENAME);
        java.util.UUID todoID = ((java.util.UUID) (intent.getSerializableExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID)));
        mToDoItems = loadData();
        if (mToDoItems != null) {
            for (com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item : mToDoItems) {
                if (item.getIdentifier().equals(todoID)) {
                    mItem = item;
                    break;
                }
            }
            if (mItem != null) {
                mToDoItems.remove(mItem);
                dataChanged();
                saveData();
            }
        }
    }


    private void dataChanged() {
        android.content.SharedPreferences sharedPreferences = getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.SHARED_PREF_DATA_SET_CHANGED, android.content.Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.CHANGE_OCCURED, true);
        editor.apply();
    }


    private void saveData() {
        try {
            storeRetrieveData.saveToFile(mToDoItems);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }


    @java.lang.Override
    public void onDestroy() {
        super.onDestroy();
        saveData();
    }


    private java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> loadData() {
        try {
            return storeRetrieveData.loadFromFile();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}