package com.example.imusictask.base;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public void goBack() {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().popBackStack();
    }
}
