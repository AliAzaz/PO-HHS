package edu.aku.hassannaqvi.uen_tmk.get;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import edu.aku.hassannaqvi.uen_tmk.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_tmk.contracts.UsersContract.singleUser;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk.core.MainApp;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class GetUsers extends AsyncTask<String, String, String> {

    private final String TAG = "GetUsers()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private ProgressDialog pd;

    public GetUsers(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing Users");
        pd.setMessage("Getting connected to server...");
        pd.show();

    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(MainApp._HOST_URL + singleUser._URI);
            urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, "User In: " + line);
                    result.append(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            urlConnection.disconnect();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string

        String json = result;
        //json = json.replaceAll("\\[", "").replaceAll("\\]","");
        Log.d(TAG, result);
        if (json.length() > 0) {
            ArrayList<UsersContract> userArrayList;
            DatabaseHelper db = new DatabaseHelper(mContext);
            try {
                userArrayList = new ArrayList<UsersContract>();
                //JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = new JSONArray(json);
                db.syncUser(jsonArray);
                pd.setMessage("Received: " + jsonArray.length());
                pd.show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // db.getAllUsers();
        } else {
            pd.setMessage("Received: " + json.length() + "");
            pd.show();
        }
    }
}