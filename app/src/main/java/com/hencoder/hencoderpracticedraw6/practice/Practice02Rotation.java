package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int translationState = 0;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转

                switch (translationState) {
                    case 0:
                        imageView.animate().rotationX(180);   // 绕着x轴，转到180的位置
                        break;
                    case 1:
                        imageView.animate().rotationX(0); // 转到0的位置
                        break;
                    case 2:
                        imageView.animate().rotationY(180); // 绕y轴，旋转到180度的位置
                        break;
                    case 3:
                        imageView.animate().rotationY(540); // 绕y轴，旋转540度，相较于 imageView.animate().rotationY(180);只需再旋转360度，而不是在180度基础上再旋转540度
                        break;
                    case 4:
                        imageView.animate().rotation(180);
                        break;
                    case 5:
                        imageView.animate().rotation(90);
                        break;

                }

                if (translationState < 6) {
                    translationState++;
                } else {
                    translationState = 0;
                }


            }
        });
    }
}