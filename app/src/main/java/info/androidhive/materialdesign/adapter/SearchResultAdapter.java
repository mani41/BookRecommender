package info.androidhive.materialdesign.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.xml.datatype.Duration;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.MainActivity;
import info.androidhive.materialdesign.model.BookUserMapper;

/**
 * Created by akash on 8/19/17.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    // Provide a suitable constructor (depends on the kind of dataset)
    private List<BookUserMapper> mDataset;
    public SearchResultAdapter(List<BookUserMapper> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchResultAdapter.ViewHolder holder, int position) {
        holder.bookImg.setImageResource(R.drawable.notification_template_icon_bg);
        holder.bookTitle.setText(mDataset.get(position).getBookBorrow().getTitle());
        holder.distance.setText(mDataset.get(position).getDistance()+" km");
        holder.barterBookTitle.setText(mDataset.get(position).getBookLend().getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView bookImg;
        public TextView  bookTitle;
        public TextView  distance;
        public TextView  barterBookTitle;
        public CardView  cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            bookImg = (ImageView)itemView.findViewById(R.id.item_image);
            bookTitle = (TextView)itemView.findViewById(R.id.item_title);
            distance = (TextView)itemView.findViewById(R.id.item_distance);
            barterBookTitle = (TextView) itemView.findViewById(R.id.item_barter);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    System.out.print(getAdapterPosition()+" position");
                    int adapterpos = getAdapterPosition();
                    Toast.makeText(v.getContext(),getAdapterPosition()+" position",Toast.LENGTH_LONG);
                }
            });

        }
    }
}
