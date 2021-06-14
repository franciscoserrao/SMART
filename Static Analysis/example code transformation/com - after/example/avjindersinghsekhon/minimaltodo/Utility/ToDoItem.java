package com.example.avjindersinghsekhon.minimaltodo.Utility;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.UUID;
import java.io.Serializable;
import java.util.Date;
public class ToDoItem implements java.io.Serializable {
    private java.lang.String mToDoText;

    private boolean mHasReminder;

    // add description
    private java.lang.String mToDoDescription;

    // private Date mLastEdited;
    private int mTodoColor;

    private java.util.Date mToDoDate;

    private java.util.UUID mTodoIdentifier;

    // add description
    private static final java.lang.String TODODESCRIPTION = "tododescription";

    private static final java.lang.String TODOTEXT = "todotext";

    private static final java.lang.String TODOREMINDER = "todoreminder";

    // private static final String TODOLASTEDITED = "todolastedited";
    private static final java.lang.String TODOCOLOR = "todocolor";

    private static final java.lang.String TODODATE = "tododate";

    private static final java.lang.String TODOIDENTIFIER = "todoidentifier";

    public ToDoItem(java.lang.String todoBody, java.lang.String tododescription, boolean hasReminder, java.util.Date toDoDate) {
        mToDoText = todoBody;
        mHasReminder = hasReminder;
        mToDoDate = toDoDate;
        mToDoDescription = tododescription;
        mTodoColor = 1677725;
        mTodoIdentifier = java.util.UUID.randomUUID();
    }


    public ToDoItem(org.json.JSONObject jsonObject) throws org.json.JSONException {
        mToDoText = jsonObject.getString(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOTEXT);
        mToDoDescription = jsonObject.getString(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODODESCRIPTION);
        mHasReminder = jsonObject.getBoolean(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOREMINDER);
        mTodoColor = jsonObject.getInt(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOCOLOR);
        mTodoIdentifier = java.util.UUID.fromString(jsonObject.getString(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOIDENTIFIER));
        // if(jsonObject.has(TODOLASTEDITED)){
        // mLastEdited = new Date(jsonObject.getLong(TODOLASTEDITED));
        // }
        if (jsonObject.has(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODODATE)) {
            mToDoDate = new java.util.Date(jsonObject.getLong(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODODATE));
        }
    }


    public org.json.JSONObject toJSON() throws org.json.JSONException {
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        jsonObject.put(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOTEXT, mToDoText);
        jsonObject.put(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOREMINDER, mHasReminder);
        jsonObject.put(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODODESCRIPTION, mToDoDescription);
        // jsonObject.put(TODOLASTEDITED, mLastEdited.getTime());
        if (mToDoDate != null) {
            jsonObject.put(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODODATE, mToDoDate.getTime());
        }
        jsonObject.put(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOCOLOR, mTodoColor);
        jsonObject.put(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem.TODOIDENTIFIER, mTodoIdentifier.toString());
        return jsonObject;
    }


    public ToDoItem() {
        this("Clean my room", "Sweep and Mop my Room", true, new java.util.Date());
    }


    public java.lang.String getmToDoDescription() {
        return mToDoDescription;
    }


    public void setmToDoDescription(java.lang.String mToDoDescription) {
        this.mToDoDescription = mToDoDescription;
    }


    public java.lang.String getToDoText() {
        return mToDoText;
    }


    public void setToDoText(java.lang.String mToDoText) {
        this.mToDoText = mToDoText;
    }


    public boolean hasReminder() {
        return mHasReminder;
    }


    public void setHasReminder(boolean mHasReminder) {
        this.mHasReminder = mHasReminder;
    }


    public java.util.Date getToDoDate() {
        return mToDoDate;
    }


    public int getTodoColor() {
        return mTodoColor;
    }


    public void setTodoColor(int mTodoColor) {
        this.mTodoColor = mTodoColor;
    }


    public void setToDoDate(java.util.Date mToDoDate) {
        this.mToDoDate = mToDoDate;
    }


    public java.util.UUID getIdentifier() {
        return mTodoIdentifier;
    }

}