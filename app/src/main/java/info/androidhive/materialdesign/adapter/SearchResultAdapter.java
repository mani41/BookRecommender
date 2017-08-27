package info.androidhive.materialdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.xml.datatype.Duration;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.MainActivity;
import info.androidhive.materialdesign.activity.UserInfoActivity;
import info.androidhive.materialdesign.model.BookUserMapper;

/**
 * Created by akash on 8/19/17.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    // Provide a suitable constructor (depends on the kind of dataset)
    private List<BookUserMapper> mDataset;
    private Context context;
    private int lastPosition = -1;
    public SearchResultAdapter(){

    }

    public SearchResultAdapter(List<BookUserMapper> myDataset,Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    public void setData(List<BookUserMapper> mDataset) {
        this.mDataset = mDataset;
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
        //holder.bookImg.setImageResource(R.drawable.notification_template_icon_bg);
        holder.bookTitle.setText(mDataset.get(position).getBookBorrow().getTitle());
        holder.distance.setText(mDataset.get(position).getDistance()+" km");
        holder.barterBookTitle.setText(mDataset.get(position).getBookLend().getTitle());
        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
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
            //itemView.setBackgroundResource(R.drawable.hp4);
            //bookImg = (ImageView)itemView.findViewById(R.id.item_image);
            bookTitle = (TextView)itemView.findViewById(R.id.item_title);
            distance = (TextView)itemView.findViewById(R.id.item_distance);
            barterBookTitle = (TextView) itemView.findViewById(R.id.item_barter);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setBackgroundResource(R.drawable.hp4);
            cardView.getBackground().setColorFilter(itemView.getContext().getColor(R.color.tint_color), PorterDuff.Mode.MULTIPLY);
            cardView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {;
                    Intent intent = new Intent(v.getContext(), UserInfoActivity.class);
                    intent.putExtra("cardPosition",getAdapterPosition());
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
