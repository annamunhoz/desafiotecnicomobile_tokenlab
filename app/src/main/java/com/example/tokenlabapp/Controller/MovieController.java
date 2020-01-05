package com.example.tokenlabapp.Controller;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tokenlabapp.Model.MovieModel;
import com.example.tokenlabapp.View.MovieActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieController {

    public MovieModel movieModel;
    public MovieActivity movieActivity;

    public void getMovieDetails(Integer movieId, MovieActivity activity) {
        movieActivity = activity;

        // insere o ID na URL e pega os dados (JSON) do filme específico
        String apiURL = "https://desafio-mobile.nyc3.digitaloceanspaces.com/movies/" + movieId;
        RequestQueue queue = Volley.newRequestQueue(movieActivity);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                movieModel = new MovieModel();
                try {
                    movieActivity.hideProgressBarMovie();
                    movieModel.setTitle(response.getString("title"));
                    movieModel.setOverview(response.getString("overview"));
                    movieModel.setVoteAverage(response.getString("vote_average"));
                    movieActivity.setMovieDetails(movieModel);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error getMovieDetails: " + error);
            }
        });

        queue.add(request);
    }
}
