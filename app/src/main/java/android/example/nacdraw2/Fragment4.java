package android.example.nacdraw2;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment implements View.OnClickListener {
    Button btn1, btn2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);

        VideoView videoView = view.findViewById(R.id.vid_basket1);

        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.vidbasket1));
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.start();

        VideoView videoView2 = view.findViewById(R.id.vid_basket2);

        videoView2.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.vidbasket1));
        videoView2.setMediaController(new MediaController(getActivity()));
        videoView2.start();

        btn1 = view.findViewById(R.id.btnbasket1);

        btn1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String txt = "https://www.youtube.com/watch?v=XbtmGKif7Ck";
        switch (view.getId()) {
            case R.id.btnbasket1:
                ShareCompat.IntentBuilder
                        .from(getActivity())
                        .setType("text/plain")
                        .setChooserTitle("Share this text with: ")
                        .setText(txt)
                        .startChooser();
        }
    }
}
