package kr.hs.emirim.s2019s11.mirimgallery;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    int[] imgRes = {R.drawable.poster1,R.drawable.poster2,R.drawable.poster3,R.drawable.poster4,R.drawable.poster5,
            R.drawable.poster6,R.drawable.poster7,R.drawable.poster8,R.drawable.poster9,R.drawable.poster10,
            R.drawable.poster11,R.drawable.poster12,R.drawable.poster13,R.drawable.poster14,R.drawable.poster15,
            R.drawable.poster16,R.drawable.poster17,R.drawable.poster18,R.drawable.poster19,R.drawable.poster20};
    String[] imgNames = {"톰보이", "타오르는 여인의 초상", "한여름의 판타지아", "테일 오브 테일즈", "호크니",
            "문라이트", "마일스", "Midnight in Paris", "행복한 라짜로", "The World Of Us",
            "패터슨", "너는 여기에 없었다", "핫썸머나이츠", "세븐", "킬유어달링",
            "카페 벨에포크", "메리셸리", "모던타임즈", "캐롤", "어린왕자"};
    Context context;
    ImageView imgvMain;
    public GalleryAdapter(Context context, ImageView imgvMain) {
        this.context = context;
        this.imgvMain = imgvMain;
    }
    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(5, 5, 5, 5);
        imgv.setImageResource(imgRes[position]);
        final View toastView = View.inflate(context, R.layout.toast, null);
        final TextView textTitle = toastView.findViewById(R.id.text_title);

        final int pos = position;
        imgv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imgvMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imgvMain.setImageResource(imgRes[pos]);
                Toast toast = new Toast(context);
                textTitle.setText(imgNames[pos]);
                toast.setView(toastView);
                toast.show();
                return false;
            }
        });
        return imgv;
    }
}
