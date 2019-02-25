package karatakushi.io.lfs_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    List<Item> mItems;

    public ItemAdapter(Context context, int layoutResourceId, List<Item> objects) {
        super(context, layoutResourceId, objects);

        mItems = objects;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Item item = getItem(position);

        if (item != null) {
            viewHolder.contentTextView.setText(item.title);
            viewHolder.contentTextView.setText(item.content);
            viewHolder.likeTextView.setText(item.likeCount + "Likes");
            if (item.isLiked){
                viewHolder.likeButton.setImageResource(R.drawable.heart);
            }else {
                viewHolder.likeButton.setImageResource(R.drawable.emptyheart);

            }
            viewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.isLiked) {
                        item.likeCount--;
                        item.isLiked = false;
                        viewHolder.likeButton.setImageResource(R.drawable.emptyheart);
                    } else {
                        item.likeCount++;
                        item.isLiked = true;
                        viewHolder.likeButton.setImageResource(R.drawable.heart);
                    }
                    viewHolder.likeTextView.setText(item.likeCount + "Likes");
                }
            });
        }

        return convertView;
    }

    public static class ViewHolder {

        TextView titleTextView;
        TextView likeTextView;
        TextView contentTextView;
        ImageView likeButton;

        public ViewHolder(View view) {
            titleTextView = view.findViewById(R.id.title_textview);
            likeTextView = view.findViewById(R.id.like_textview);
            contentTextView = view.findViewById(R.id.content);
            likeButton = view.findViewById(R.id.like_button);
        }
    }
}
