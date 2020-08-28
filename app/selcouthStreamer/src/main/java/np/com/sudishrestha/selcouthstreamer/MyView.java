package np.com.sudishrestha.selcouthstreamer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MyView extends LinearLayout {
    private void initialize(Context context){
        inflate(context, R.layout.my_view, this);
    }
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}