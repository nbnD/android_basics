package com.flutterjunction.sqlitedemo.database_helper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentsDatabase {

    public static final String Key_RowId = "_id";
    public static final String Key_Name = "person_name";
    public static final String Key_Cell = "_cell";

    private final String Database_Name = "StudentDatabase"; //Database Name
    private final String Database_Table = "ContactsTavle";
    private final int Database_Version = 1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourdatabase;

    public StudentsDatabase(Context context) {
        ourContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, Database_Name, null, Database_Version);

        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlcode = "CREATE TABLE ContactsTable(_id INTEGER PRIMARY KEY AUTOINCREMENT, person_name TEXT NOT NULL, _cell TEXT NOT NULL);";
            db.execSQL(sqlcode);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + Database_Table);
            onCreate(db);
        }
    }
    public StudentsDatabase open() throws SQLException {
        ourHelper = new DBHelper(ourContext);
        ourdatabase = ourHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        ourHelper.close();
    }
    public long creat(String name, String cell) {
        ContentValues cv = new ContentValues();
        cv.put(Key_Name, name);
        cv.put(Key_Cell, cell);
        return ourdatabase.insert(Database_Table, null, cv);
    }
    public String returndata() {
        String[] column = new String[] {
                Key_RowId,
                Key_Name,
                Key_Cell
        };
        Cursor c = ourdatabase.query(Database_Table, column, null, null, null, null, null);
        String resu = "";
        int irowid = c.getColumnIndex(Key_RowId);
        int iname = c.getColumnIndex(Key_Name);
        int icell = c.getColumnIndex(Key_Cell);
        for (c.moveToFirst(); c.isAfterLast(); c.moveToNext()) {
            resu = resu + c.getString(irowid) + ":" + c.getString(iname) + " " + c.getString(icell) + "\n";
        }
        c.close();
        return resu;
    }
    public long deleteEnter(String rowId) {
        return ourdatabase.delete(Database_Table, Key_RowId + "=?", new String[] {
                rowId
        });
    }

    public long update(String rowId, String cell, String name) {
        ContentValues cu = new ContentValues();
        cu.put(Key_Name, name);
        cu.put(Key_Cell, cell);
        return ourdatabase.update(Database_Table, cu, Key_RowId + "=?", new String[] {
                rowId
        });
    }
}
