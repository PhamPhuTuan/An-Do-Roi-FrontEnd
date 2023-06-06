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

public class CommentAdapter extends ArrayAdapter<PostReaction> {
    private Context context;
    private List<PostReaction> postReactionsItems;

    public CommentAdapter(Context context, List<PostReaction> postItems) {
        super(context, 0, postItems);
        this.context = context;
        this.postReactionsItems = postItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        }
        Log.d("bug", "voo adapter");

        PostReaction postReactionItem = postReactionsItems.get(position);

        TextView CommentTextView = view.findViewById(R.id.commentTextView);
        TextView NameTextView = view.findViewById(R.id.nameTextView);

        CommentTextView.setText(postReactionItem.getComment());
        NameTextView.setText(postReactionItem.getUserInfo().getLastname());

        return view;
    }
}
