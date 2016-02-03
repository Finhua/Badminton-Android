package com.example.android.badmintonscoreboard;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by hong on 05/08/15.
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView gameTitle;

        GameViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            gameTitle = (TextView)itemView.findViewById(R.id.game_title);
        }

    }

    List<Game> games;

    GameAdapter(List<Game> games){
        this.games = games;
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_entry, viewGroup, false);
        GameViewHolder gvh = new GameViewHolder(v);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GameViewHolder gameViewHolder, int i) {
        gameViewHolder.gameTitle.setText(games.get(i).title);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
