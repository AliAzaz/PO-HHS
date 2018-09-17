package edu.aku.hassannaqvi.uen_tmk.sync;

/**
 * Created by hassan.naqvi on 12/2/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import edu.aku.hassannaqvi.uen_tmk.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk.core.MainApp;

/**
 * Created by hassan.naqvi on 7/26/2016.
 */
public class SyncMwras extends AsyncTask<String, String, String> {

    private static final String TAG = "SyncMWRA";
    private Context mContext;
    private ProgressDialog pd;

    public SyncMwras(Context context) {
        mContext = context;
    }

    public static void longInfo(String str) {
        if (str.length() > 4000) {
            Log.i(TAG, str.substring(0, 4000));
            longInfo(str.substring(4000));
        } else
            Log.i(TAG, str);
    }

    @Override
    protected String doInBackground(String... strings) {
        String line = "No Response";
        try {
            String url = MainApp._HOST_URL + MWRAContract.MWRATable._URL;
            Log.d(TAG, "doInBackground: URL " + url);
            return downloadUrl(url);
        } catch (IOException e) {
            return "Unable to upload data. Server may be down.";
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Please wait... Processing MWRA");
        pd.show();

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int sSynced = 0;
        String sSyncedError = "";
        JSONArray json = null;
        try {
            json = new JSONArray(result);
            DatabaseHelper db = new DatabaseHelper(mContext);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = new JSONObject(json.getString(i));
                if (jsonObject.getString("status").equals("1") && jsonObject.getString("error").equals("0")) {
                    db.updateMWRAs(jsonObject.getString("id"));
                    sSynced++;
                } else {
                    sSyncedError += "\nError: " + jsonObject.getString("message").toString();
                }
            }
            Toast.makeText(mContext, sSynced + " MWRA's synced." + String.valueOf(json.length() - sSynced) + " Errors: " + sSyncedError, Toast.LENGTH_SHORT).show();

            pd.setMessage(sSynced + " MWRA's synced." + String.valueOf(json.length() - sSynced) + " Errors: " + sSyncedError);
            pd.setTitle("Done uploading MWRA's data");
            pd.show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Failed Sync MWRA's" + result, Toast.LENGTH_SHORT).show();

            pd.setMessage(result);
            pd.setTitle("MWRA's Sync Failed");
            pd.show();
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        String line = "No Response";
        // Only display the first 500 characters of the retrieved
        // web page content.
        //int len = 500;
        DatabaseHelper db = new DatabaseHelper(mContext);
        Collection<MWRAContract> MWRA = db.getUnsyncedMWRA();
        Log.d(TAG, String.valueOf(MWRA.size()));
        if (MWRA.size() > 0) {
            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                int HttpResult = conn.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    JSONArray jsonSync = new JSONArray();

                    conn = (HttpURLConnection) url.openConnection();

                    conn.setReadTimeout(20000 /* milliseconds */);
                    conn.setConnectTimeout(30000 /* milliseconds */);
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("charset", "utf-8");
                    conn.setUseCaches(false);
                    // Starts the query
                    conn.connect();

                    try {
                        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

                        for (MWRAContract fc : MWRA) {

                            //if (fc.getIstatus().equals("1")) {
                            jsonSync.put(fc.toJSONObject());
                            //}

                        }
                        wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");
                        longInfo(jsonSync.toString().replace("\uFEFF", "") + "\n");
                        wr.flush();
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

/*===================================================================*/

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream(), "utf-8"));
                    StringBuffer sb = new StringBuffer();

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    System.out.println("" + sb.toString());
                    return sb.toString();
                } else {
                    System.out.println(conn.getResponseMessage());
                    return conn.getResponseMessage();
                }
            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else {
            return "No new records to sync";
        }
        return line;
            /*===================================================================*/

    }

   /* public String readIt(InputStream stream) throws IOException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }*/
}