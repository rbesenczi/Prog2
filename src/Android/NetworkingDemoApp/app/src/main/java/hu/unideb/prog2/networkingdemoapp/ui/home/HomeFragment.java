package hu.unideb.prog2.networkingdemoapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import hu.unideb.prog2.networkingdemoapp.MainActivity;
import hu.unideb.prog2.networkingdemoapp.NetworkService;
import hu.unideb.prog2.networkingdemoapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private void sendMessage(String msg){
        Intent intent = new Intent(getActivity(), NetworkService.class);
        intent.putExtra("activity", "sendmessage");
        intent.putExtra("message", msg);
        getActivity().startService(intent);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Intent intent = new Intent(getActivity(), NetworkService.class);
        intent.putExtra("activity", "startnetworking");
        getActivity().startService(intent);

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final Button someButton = binding.button;
        someButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("someButton clicked");
                sendMessage("someButton clicked");
            }
        });

        final Button otherButton = binding.button2;
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("otherButton clicked");
                sendMessage("otherButton clicked");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}