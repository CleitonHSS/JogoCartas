package assessment.android.cleiton.jogocartas;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Inicio extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        MaterialButton nextButton = view.findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ((NavigationHost) getActivity()).navigateTo(new Game(), false); // Navigate to the next Fragment
            }
        });

        return view;
    }

}
