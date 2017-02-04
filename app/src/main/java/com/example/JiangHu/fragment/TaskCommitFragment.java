package com.example.JiangHu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.JiangHu.R;

/**
 * Created by 10038108 on 2017/2/4.
 */

public class TaskCommitFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_submit_task, null);

        Spinner spinner = (Spinner) view.findViewById(R.id.universities_spinner);
        spinner.setAdapter(ArrayAdapter.createFromResource(getContext(), R.array.universities,android.R.layout.simple_spinner_dropdown_item));


        Spinner workType = (Spinner) view.findViewById(R.id.task_type);
        workType.setAdapter(ArrayAdapter.createFromResource(getContext(), R.array.taskType,android.R.layout.simple_spinner_dropdown_item));

       view.findViewById(R.id.edit_beginTime).setEnabled(false);
       view.findViewById(R.id.edit_endTime).setEnabled(false);

        return view;
    }


    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }
}
