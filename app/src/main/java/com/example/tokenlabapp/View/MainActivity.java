package com.example.tokenlabapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tokenlabapp.Controller.AsyncTaskLoadImage;
import com.example.tokenlabapp.Controller.MainController;
import com.example.tokenlabapp.Model.MovieModel;
import com.example.tokenlabapp.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ProgressBar progressBar;

    private MainController mainController = new MainController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        progressBar = findViewById(R.id.progressBar);

        mainController.getMovies(this);
    }

    public void setMoviesList(MovieModel[] movies) {
        for (int i = 0 ; i < movies.length; i++) {
            ImageButton imageButton = new ImageButton(MainActivity.this);
            new AsyncTaskLoadImage(imageButton).execute(movies[i].getPosterImageUrl());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            imageButton.setLayoutParams(params);
            // passa o id do filme para o botão
            imageButton.setTag(movies[i].getId());
            linearLayout.addView(imageButton);

            imageButton.setOnClickListener(listener);

            TextView textView = new TextView(MainActivity.this);
            textView.setText(movies[i].getTitle());
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setPadding(20, 0, 20, 60);
            linearLayout.addView(textView);
        }
    }

    View.OnClickListener listener =  new View.OnClickListener() {
        @Override
        public void onClick(View imageButton) {
            openMovieActivity((Integer) imageButton.getTag());
        }
    };

    public void openMovieActivity(Integer movieId){
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("MOVIE_ID", movieId);
        startActivity(intent);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(ProgressBar.GONE);
    }
}