package com.example.umang.anim_test;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Data extends AsyncTask< Void,Void,Void> {
    String data;
    String probability="",gender="";

    @Override
    protected Void  doInBackground(Void... voids) {

        try {
            Log.e("Data Class","Yayyyy!!");
            String temp=Display.editText.getText().toString();
            URL url=new URL("https://api.genderize.io/?name="+temp);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null)
            {
                line=bufferedReader.readLine();
                data=data+line;
            }
            data.trim();

            Log.e("Data Class",data);
            data=data.substring(4);
            JSONObject jo= new JSONObject(data);
            probability=""+jo.get("probability");
            gender=""+jo.get("gender");




        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("Data Class","1");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Data Class","2");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Data Class","3",e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Display.name.setText(this.gender);
        Display.gender.setText("Probability:"+this.probability);
    }
}
