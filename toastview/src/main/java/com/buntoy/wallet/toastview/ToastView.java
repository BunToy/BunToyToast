package com.buntoy.wallet.toastview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastView {
    public static ToastView mToastView;
    private static Toast toast;

    /**
     * 显示时间长短
     */
    private static final int TIME_LONG = 1;

    /**
     * 距离中心高度
     */
    private static final int TOP_HEIGHT = 400;

    /**
     * 字体颜色
     */
    private static final int TEXT_COLOR = R.color.text_black;

    /**
     * 字体大小
     */
    private static final int TEXT_SIZE = 15;


    /**
     * 双重锁定，使用同一个Toast实例
     */
    public static ToastView getBuilder() {
        if (mToastView == null) {
            synchronized (ToastView.class) {
                if (mToastView == null) {
                    mToastView = new ToastView();
                }
            }
        }
        return mToastView;
    }

    /**
     * 显示一个纯文本吐司
     *
     * @param context 上下文
     * @param text  显示的文本
     */
    public void showToast(Context context, String text) {
        showToastView(context, text, TEXT_COLOR,TEXT_SIZE,TIME_LONG, TOP_HEIGHT,null,R.drawable.background_toast_shape);
    }

    /**
     * 更改文本颜色
     *
     * @param context 上下文
     * @param text  显示的文本
     */
    public void showToast(Context context, String text,int color) {
        showToastView(context, text, color,TEXT_SIZE,TIME_LONG, TOP_HEIGHT,null,R.drawable.background_toast_shape);
    }

    /**
     * 更改文本字体大小
     *
     * @param context 上下文
     * @param text  显示的文本
     */
    public void showToast(Context context, String text,int color,int textSize) {
        showToastView(context, text, color,textSize,TIME_LONG, TOP_HEIGHT,null,R.drawable.background_toast_shape);
    }

    /**
     * 显示一个带图标吐司
     *
     * @param context 上下文
     * @param text  显示的文本
     */
    public void showToast(Context context, String text,Drawable drawable) {
        showToastView(context, text, TEXT_COLOR ,TEXT_SIZE,TIME_LONG, TOP_HEIGHT,drawable,R.drawable.background_toast_shape);
    }

    /**
     * 显示更改所有样式
     *
     * @param context 上下文
     * @param text  显示的文本
     */
    public void showToast(Context context, String text,int color,int textSize, Drawable drawable,int bg) {
        showToastView(context, text, color ,textSize,TIME_LONG, TOP_HEIGHT,drawable,bg);
    }

    /**
     * 显示toast
     *
     * @param context 上下文
     * @param text  显示的文本
     * @param time  显示时长
     * @param top 距离中心高度
     */
    private static void showToastView(Context context, String text,int color,int textSize, int time, int top,Drawable drawable,int bg) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        //设置背景样式
        view.setBackgroundResource(bg);

        TextView textView = view.findViewById(R.id.textToast);
        ImageView icon=view.findViewById(R.id.icon);

        // 初始化一个新的toast对象
        toast = new Toast(context);

        //设置显示内容
        textView.setText(text);

        //设置显示内容大小
        textView.setTextSize(textSize);

        //设置显示内容颜色
        textView.setTextColor(color);

        // 设置显示时长
        if (time == TIME_LONG) {
            toast.setDuration(Toast.LENGTH_LONG);
        } else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }

        // 设置图标是否显示
        if (drawable == null) {
            icon.setVisibility(View.GONE);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                icon.setBackground(drawable);
                icon.setVisibility(View.VISIBLE);
            }else{
                icon.setVisibility(View.GONE);
            }
        }

        //设置显示位置
        toast.setGravity(Gravity.CENTER, 0, top);

        toast.setView(view);

        // 显示toast
        toast.show();
    }


    public void toastCancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

}