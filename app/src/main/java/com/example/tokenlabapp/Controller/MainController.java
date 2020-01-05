package com.example.tokenlabapp.Controller;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tokenlabapp.Model.MovieModel;
import com.example.tokenlabapp.View.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainController {

    private MainActivity mainActivity;
    private MovieModel[] movies;

    // pega a lista de objetos da URL (JSON)
    public void getMovies(MainActivity activity) {
        mainActivity = activity;

        String apiURL = "https://desafio-mobile.nyc3.digitaloceanspaces.com/movies";

        RequestQueue queue = Volley.newRequestQueue(mainActivity);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, apiURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                movies = new MovieModel[response.length()];
                try {
                    mainActivity.hideProgressBar();

                    // cria um MovieModel para cada item do JSON
                    for (int i = 0; i < response.length(); i++) {
                        movies[i] = getMovieModel(response.getJSONObject(i));
                    }

                    // envia a lista inteira de MovieModel para renderizar na MainActivity
                    mainActivity.setMoviesList(movies);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error getMovies: " + error);
            }
        });

        queue.add(request);
    }

    // recebe um JSON e retorna um MovieModel
    private MovieModel getMovieModel(JSONObject movieJson) throws JSONException {
        MovieModel movieModel = new MovieModel();
        movieModel.setPosterImageUrl(movieJson.getString("poster_url"));
        movieModel.setId(movieJson.getInt("id"));
        movieModel.setTitle(movieJson.getString("title"));
        return movieModel;
    }
}
