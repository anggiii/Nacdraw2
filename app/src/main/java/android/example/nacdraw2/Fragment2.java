package android.example.nacdraw2;

import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Fragment2 extends Fragment implements View.OnClickListener {

    Button btn1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        VideoView videoView = view.findViewById(R.id.vid_lari);


        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.vidlari1));
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.start();

        VideoView videoView2 = view.findViewById(R.id.vid_lari2);

        videoView2.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.vidlari2));
        videoView2.setMediaController(new MediaController(getActivity()));
        videoView2.start();

        btn1 = view.findViewById(R.id.btnlari1);

        btn1.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        String txt = "https://www.youtube.com/watch?v=3YrVHNqkz7A&t=137s";
        if (view.getId() == R.id.btnlari1) {
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType("text/plain")
                    .setChooserTitle("Share this text with: ")
                    .setText(txt)
                    .startChooser();
            }
        }
    }
