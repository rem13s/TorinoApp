package com.example.remusdobrican.turapp;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import android.os.AsyncTask;
import com.google.android.gms.maps.model.LatLng;
import java.util.concurrent.ExecutionException;

public class Direction {
    List<LatLng> finalPoints = null;
    public List<LatLng> executingRequest(LatLng userLoc, LatLng destLoc, String api_k)
    {
        String url = buildDirectionURL(userLoc, destLoc, api_k);
        DownloadTask dlTask = new DownloadTask();
        dlTask.execute(url);
        try {
            String data = dlTask.get();
            ParserTask parserTask = new ParserTask();
            List<LatLng> returned = null;
            parserTask.execute(data);
            try {
                finalPoints = parserTask.get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return finalPoints;
    }

    public String buildDirectionURL(LatLng userLocation, LatLng destination, String api_key)
    {
        String str_origin = "origin=" + userLocation.latitude + "," + userLocation.longitude;
        String str_destination = "destination=" + destination.latitude + "," + destination.longitude;
        String outputType = "json";
        String parameters = str_origin + "&" + str_destination + "&" + "key=" + api_key;
        String direction_url = "https://maps.googleapis.com/maps/api/directions/" + outputType +"?" + parameters;
        return direction_url;
    }
    private class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try{data = downloadUrl(url[0]);
            }catch(Exception e){
            }
            return data;
        }
    }
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb  = new StringBuffer();
            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }
            data = sb.toString();
            br.close();
        }catch(Exception e){

        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
    private class ParserTask extends AsyncTask<String, Integer, List<LatLng> > {
        @Override
        protected List<LatLng> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<LatLng> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                Parser parser = new Parser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }


    }



}
