package np.com.sudishrestha.selcouthstreamer.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import np.com.sudishrestha.selcouthstreamer.R;
import np.com.sudishrestha.selcouthstreamer.model.messages;

public class messageAdapter  extends RecyclerView.Adapter<messageAdapter.MyViewHolder> {

    private List<messages> messagesList;
Boolean visible = false;
    Context mContext;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profile_pic;
        public MyViewHolder(View view) {
            super(view);
            profile_pic = view.findViewById(R.id.profile_pic);
        }
    }


    public messageAdapter(List<messages> messagesList,Boolean visible, Context mContext) {
        this.messagesList = messagesList;
        this.visible=visible;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (position) {
            case 0:
                Glide.with(mContext).load("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=500").circleCrop().into(holder.profile_pic);
                break;
            case 1:
                Glide.with(mContext).load("https://randomuser.me/api/portraits/men/81.jpg").circleCrop().into(holder.profile_pic);
                break;
            case 2:
                Glide.with(mContext).load("https://randomuser.me/api/portraits/women/33.jpg").circleCrop().into(holder.profile_pic);
                break;
            case 3:
                Glide.with(mContext).load("https://randomuser.me/api/portraits/men/36.jpg").circleCrop().into(holder.profile_pic);
                break;
            case 4:
                Glide.with(mContext).load("https://randomuser.me/api/portraits/women/69.jpg").circleCrop().into(holder.profile_pic);
                break;


        }

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }
}
