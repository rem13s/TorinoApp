package com.example.remusdobrican.turapp;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {
        public List<LatLng> parse(JSONObject jObject){
            List<List<HashMap<String, String>>> routes = new ArrayList<List<HashMap<String,String>>>() ;
            JSONArray jRoutes = null;
            JSONArray jLegs = null;
            JSONArray jSteps = null;
            String destination_address = "";
            String distance = "";
            List<LatLng> points = null;
            try {
                jRoutes = jObject.getJSONArray("routes");
                for(int i=0;i<jRoutes.length();i++){
                    jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
                    List<HashMap<String, String>> path = new ArrayList<HashMap<String, String>>();
                    String overViewPolyLine = (String)((JSONObject)((JSONObject) jRoutes.get(i)).get("overview_polyline")).get("points");
                    points = decodePolyLine(overViewPolyLine);
                    for(int j=0;j<jLegs.length();j++){
                                      jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");
                        distance = (String)((JSONObject)((JSONObject)jLegs.get(j)).get("distance")).get("text");
                        Log.d("DISTANCE:", distance);
                        for(int k=0;k<jSteps.length();k++){
                            String polyline = "";
                            if((boolean)(((JSONObject)jSteps.get(k)).has("html_instructions")))
                            {
                                String html=(String)(((JSONObject)jSteps.get(k)).get("html_instructions"));
                                html=html.replaceAll("\\<.*?>","");
                                // Dec.html_instructions.add(html);
                                Log.d("html_instructions", html);
                            }
                            else
                            {
                                Log.d("SIDE", "NO Side");
                            }
                            if((boolean)(((JSONObject)jSteps.get(k)).has("maneuver")))
                            {
                                String side=(String)(((JSONObject)jSteps.get(k)).get("maneuver"));
                                Log.d("SIDE", side);
                            }
                            else
                            {
                                Log.d("SIDE", "NO Side");
                            }
                            polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");
                        }
                        routes.add(path);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }catch (Exception e){
            }
            return points;
        }
        private List<LatLng> decodePolyLine (String encodedPolyLine)
        {
            List<LatLng> pointArr = new ArrayList<LatLng>();
            int index = 0;
            int lat = 0, lng = 0;

            while (index < encodedPolyLine.length()) {
                int b, shift = 0, result = 0;
                do {
                    b = encodedPolyLine.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encodedPolyLine.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng(( (double)lat/1E5),( (double)lng/1E5 ));
                pointArr.add(p);
            }
            return pointArr;
        }
}
