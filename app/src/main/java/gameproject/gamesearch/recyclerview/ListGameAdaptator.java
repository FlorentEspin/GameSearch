package gameproject.gamesearch.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gameproject.gamesearch.GameInformation;
import gameproject.gamesearch.Jeu;
import gameproject.gamesearch.R;

public class ListGameAdaptator extends RecyclerView.Adapter<ListGameAdaptator.ViewHolder> {
    private List<Jeu> listJeu = new ArrayList<Jeu>();

    public ListGameAdaptator(List<Jeu> jeux) {
      this.listJeu = jeux;
    }
    
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.item_layout, null);

        // create ViewHolder
       
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        
    	// - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
    	try {
            viewHolder.txtViewTitle.setText(listJeu.get(position).getNomJeu());
            viewHolder.ID.setText(String.valueOf(listJeu.get(position).getIdJeu()));
        }
        catch (Exception e)
        {
            e.toString();
        }
    //	viewHolder.imgViewIcon.setImageResource(listUser[position].getImageUrl());


    }

    
    // inner class to hold a reference to each item of RecyclerView 
    public static class ViewHolder extends RecyclerView.ViewHolder {

    	public TextView txtViewTitle;
        public ImageView imgViewIcon;
        public TextView ID;

        public ViewHolder(final View itemLayoutView) {
            super(itemLayoutView);
            try {
                txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
                imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
                ID = (TextView) itemLayoutView.findViewById(R.id.idBDD);
                // Handle item click and set the selection
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = itemView.getContext();
                        CharSequence text = (CharSequence) txtViewTitle.getText();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        Intent intentJeux = new Intent(context,GameInformation.class);
                        intentJeux.putExtra("ID",ID.getText());
                        context.startActivity(intentJeux);
                        toast.show();

                    }
                });
            }
            catch (Exception e) {
                e.toString();
            }
        }
        }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listJeu.size();
    }
}