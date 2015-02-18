package com.ziyang0621.friends;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by ziyang0621 on 2/18/15.
 */
public class FriendsDatabase extends SQLiteOpenHelper {
    private static final String TAG = FriendsDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "friends.db";
    private static final int DATABASE_VERSION = 2;
    private final Context mContext;

    interface Tables {
        String FRIENDS = "friends";
    }

    public FriendsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tables.FRIENDS + " ("
                + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FriendsContract.FriendsColumns.FRIENDS_NAME + " TEXT NOT NULL,"
                + FriendsContract.FriendsColumns.FRIENDS_EMAIL + " TEXT NOT NULL,"
                + FriendsContract.FriendsColumns.FRIENDS_PHONE + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int version = oldVersion;
        if (version == 1) {
            // Add some extra fields to the database without delete existing data
            version = 2;
        }
        if (version != DATABASE_VERSION) {
            db.execSQL("DROP TABLE IF EXISTS " + Tables.FRIENDS);
            onCreate(db);
        }
    }

    public static void deleteDatabse(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }
}
