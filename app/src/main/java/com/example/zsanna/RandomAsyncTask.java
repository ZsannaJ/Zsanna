package com.example.zsanna;
import android.os.AsyncTask;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Random;
public class RandomAsyncTask extends AsyncTask <Void, Void, String> {
    private WeakReference<TextView> mTextView;
    RandomAsyncTask(TextView tv) {mTextView = new WeakReference<>(tv);}
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int ms = n * 1000;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Bejelentekezés vendégként";
    }
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
