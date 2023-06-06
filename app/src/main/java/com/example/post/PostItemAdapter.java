package com.example.post;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.post.PostItem;
import com.example.post.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostItemAdapter extends ArrayAdapter<Post> {
    private Context context;
    private List<Post> postItems;

    public PostItemAdapter(Context context, List<Post> postItems) {
        super(context, 0, postItems);
        this.context = context;
        this.postItems = postItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        }

        Post postItem = postItems.get(position);


        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView commentCountTextView = view.findViewById(R.id.commentCountTextView);
        TextView LikeCountTextView = view.findViewById(R.id.LikeCountTextView);

        titleTextView.setText(postItem.getCaption());
        commentCountTextView.setText(String.valueOf(postItem.getCountComment()));
        nameTextView.setText(postItem.getUserInfo().getLastname());
        LikeCountTextView.setText(String.valueOf(postItem.getCountlike()));

        ImageView commentImageView = view.findViewById(R.id.commentImageView);
        ImageView likeImageView = view.findViewById(R.id.likeImageView);

        final int postId = postItem.getId();
        final int userId = postItem.getOwnerId();

        commentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onCommentClick(postId, userId);
                }
            }
        });
        likeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    Log.d("bug","voo onclick like");
                    clickListener1.onLikeClick(postId, userId);
                }
            }
        });

        return view;
    }
    public interface OnCommentClickListener {
        void onCommentClick(int postId, int userId);
    }
    private OnCommentClickListener clickListener;

    public void setOnCommentClickListener(OnCommentClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnLikeClickListener {
        void onLikeClick(int postId,int userId);
    }
    private OnLikeClickListener clickListener1;

    public void setOnLikeClickListener(OnLikeClickListener clickListener) {
        this.clickListener1 = clickListener;
    }
}
