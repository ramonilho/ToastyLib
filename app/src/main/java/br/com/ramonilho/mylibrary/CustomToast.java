package br.com.ramonilho.mylibrary;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by logonrm on 02/08/2017.
 */

public class CustomToast {

    public static final int DEFAULT = 0;
    public static final int ERROR = 1;
    public static final int SUCCESS = 2;
    public static final int INFO = 3;
    public static final int WARNING = 4;

    public void show(Context context, String mensagem, int toastType, int duration) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View toastRoot = inflater.inflate(R.layout.custom_toast, null);

        Toast toast = new Toast(context);

        toast.setView(toastRoot);

        TextView textView = (TextView) toastRoot.findViewById(R.id.textView);
        textView.setText(mensagem);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
        toast.setDuration(duration);

        ImageView imageView = (ImageView) toastRoot.findViewById(R.id.ivIcon);

        switch (toastType) {
            case SUCCESS:
                imageView.setImageResource(R.drawable.ic_success);
                break;
            case INFO:
                imageView.setImageResource(R.drawable.ic_info);
                break;
            case WARNING:
                imageView.setImageResource(R.drawable.ic_warning);
                break;
            case ERROR:
                imageView.setImageResource(R.drawable.ic_error);
                break;
            case DEFAULT:
                imageView.setImageResource(R.drawable.ic_default);
                break;
            default:
                imageView.setImageResource(R.drawable.ic_default);
                break;
        }

        toast.show();
    }

}
