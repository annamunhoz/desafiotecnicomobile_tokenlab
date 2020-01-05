package com.example.tokenlabapp.View;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tokenlabapp.Controller.MovieController;
import com.example.tokenlabapp.Model.MovieModel;
import com.example.tokenlabapp.R;

public class MovieActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView overviewTextView;
    private TextView voteAverageTextView;
    private ProgressBar progressBar;

    private MovieController movieController = new MovieController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        titleTextView = findViewById(R.id.textTitle);
        overviewTextView = findViewById(R.id.textOverview);
        voteAverageTextView = findViewById(R.id.voteAverage);
        progressBar = findViewById(R.id.progressBar);

        // pega o movieId do intent
        Integer movieId = getIntent().getIntExtra("MOVIE_ID", 0);
        movieController.getMovieDetails(movieId, this);
    }

    public void setMovieDetails(MovieModel movieModel) {
        titleTextView.setText(movieModel.getTitle());
        overviewTextView.setText(movieModel.getOverview());
        voteAverageTextView.setText("Vote average: " + movieModel.getVoteAverage());
    }

    public void hideProgressBarMovie() {
        progressBar.setVisibility(ProgressBar.GONE);
    }
}