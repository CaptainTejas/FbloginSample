package sample.shinde.tejas.com.fbloginsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class UserProfile extends Activity {
    JSONObject response,profile_pic_data, getProfile_pic_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("userProfile");
        Log.w("JSONdata",jsondata);

        TextView UserName = (TextView)findViewById(R.id.UserName);
        ImageView profilePic = (ImageView)findViewById(R.id.profilePic);
        TextView u_email = (TextView)findViewById(R.id.email);

        try {

            response = new JSONObject(jsondata);

            u_email.setText(response.get("email").toString());
            UserName.setText(response.get("name").toString());
            profile_pic_data = new JSONObject(response.get("picture").toString());
            getProfile_pic_url =new JSONObject(profile_pic_data.getString("data"));
            Picasso.with(this).load(getProfile_pic_url.getString("url")).into(profilePic);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
