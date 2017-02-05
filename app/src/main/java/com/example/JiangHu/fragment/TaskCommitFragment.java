package com.example.JiangHu.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.JiangHu.Constant;
import com.example.JiangHu.R;
import com.example.JiangHu.TaskItem;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 10038108 on 2017/2/4.
 */

public class TaskCommitFragment extends Fragment {


    Button btnBeginTime ,btnEndTime;
    MaterialEditText beginTimeText;
    MaterialEditText endTimeText;

    MaterialEditText headerLineEdit;
    MaterialEditText locationEdit;
    MaterialEditText descEdit;
    MaterialEditText contactorEdit;
    MaterialEditText phoneNumberEdit;
    MaterialEditText paymentEdit;

    Button btnOnOk, btnOnCancel;

    Spinner universityChoice;
    Spinner workTypeChoice;
    Spinner taskAvailability;



    private void installedButton()
    {
        btnOnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskItem item = new TaskItem();
                item.setUniversity(universityChoice.getSelectedItem().toString());
                item.setLocation(locationEdit.getText().toString());
                item.setTitle(headerLineEdit.getText().toString());
                item.setContent(descEdit.getText().toString());
                item.setWorkType(workTypeChoice.getSelectedItem().toString());
                item.setAcccessbility(getAvailable(taskAvailability.getSelectedItem().toString()));
                item.setBeginDate(beginTimeText.getText().toString());
                item.setEndDate(endTimeText.getText().toString());
                item.setContactor(contactorEdit.getText().toString());
                item.setPhoneNumber(phoneNumberEdit.getText().toString());
                item.setPayment(paymentEdit.getText().toString());
                item.setStatus("1");

                Constant.TaskFactory.add(0,item);

                FragmentManager fm = getFragmentManager();
                TaskListTabFrament fragment2 = (TaskListTabFrament) fm.findFragmentByTag(Constant.TAGS[1]);

                if (fragment2 != null) {
                    fragment2.refresh();
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提交任务");
                builder.setMessage("提交任务成功");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();



               // transaction.show(getFragmentManager().findFragmentByTag("discover"));

//                TaskListTabFrament fragment = new TaskListTabFrament();
//

//
//
//                transaction.replace(R.id.content_frame, fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();

            }

            private String getAvailable(String s) {
                if (s.equalsIgnoreCase("本校"))
                    return "0";
                else if (s.equalsIgnoreCase("全市"))
                    return "1";
                else
                   return "2";

            }

        });
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_submit_task, null);


        installedVariable(view);

        installedButton();
        installedTimeDatePicker();


        return view;
    }

    private void installedVariable(View view) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:00");
        Date date = new Date();
        universityChoice = (Spinner) view.findViewById(R.id.universities_spinner);
        universityChoice.setAdapter(ArrayAdapter.createFromResource(getContext(), R.array.universities,android.R.layout.simple_spinner_dropdown_item));


        workTypeChoice = (Spinner) view.findViewById(R.id.task_type);
        workTypeChoice.setAdapter(ArrayAdapter.createFromResource(getContext(), R.array.taskType,android.R.layout.simple_spinner_dropdown_item));


        taskAvailability = (Spinner) view.findViewById(R.id.task_available);
        taskAvailability.setAdapter(ArrayAdapter.createFromResource(getContext(), R.array.accessbility,android.R.layout.simple_spinner_dropdown_item));


        beginTimeText = (MaterialEditText) view.findViewById(R.id.edit_beginTime);
        beginTimeText.setText(fmt.format(date));
        beginTimeText.setEnabled(false);
        endTimeText = (MaterialEditText) view.findViewById(R.id.edit_endTime);
        endTimeText.setText(fmt.format(date));
        endTimeText.setEnabled(false);
        btnBeginTime = (Button) view.findViewById(R.id.btn_begin);
        btnEndTime = (Button) view.findViewById(R.id.btn_end);

        btnOnOk = (Button) view.findViewById(R.id.btn_OK);
        btnOnCancel = (Button) view.findViewById(R.id.btn_Cancel);

        headerLineEdit = (MaterialEditText) view.findViewById(R.id.edit_headline);
        locationEdit = (MaterialEditText) view.findViewById(R.id.edit_location);
        descEdit= (MaterialEditText) view.findViewById(R.id.edit_desc);
        contactorEdit = (MaterialEditText) view.findViewById(R.id.edit_contactor);
        phoneNumberEdit = (MaterialEditText) view.findViewById(R.id.edit_phone);
        paymentEdit = (MaterialEditText) view.findViewById(R.id.edit_payment);
    }

    private void installedTimeDatePicker() {
        btnBeginTime.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Calendar now = Calendar.getInstance();

                 TimePickerDialog tpd = TimePickerDialog.newInstance(
                         new MyTimePickListener(beginTimeText),
                         now.get(Calendar.HOUR_OF_DAY),
                         now.get(Calendar.MINUTE),
                         false);
                 tpd.setTitle("起始时间");
                 tpd.show(getActivity().getFragmentManager(), "开始时间");


                 DatePickerDialog dpd = DatePickerDialog.newInstance(
                         new MyDatePickListerner(beginTimeText),
                         now.get(Calendar.YEAR),
                         now.get(Calendar.MONTH),
                         now.get(Calendar.DAY_OF_MONTH)
                 );
                 dpd.setTitle("起始日期");
                 dpd.show(getActivity().getFragmentManager(), "开始日前");
             }
         });

        btnEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar now = Calendar.getInstance();

                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        new MyTimePickListener(endTimeText),
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false);
                tpd.setTitle("起始时间");
                tpd.show(getActivity().getFragmentManager(), "开始时间");


                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new MyDatePickListerner(endTimeText),
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setTitle("起始日期");
                dpd.show(getActivity().getFragmentManager(), "开始日前");
            }
        });
    }


    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }


}

class MyDatePickListerner implements DatePickerDialog.OnDateSetListener
{

    private final MaterialEditText editText;

    public MyDatePickListerner(MaterialEditText text)
    {
        this.editText = text;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        StringBuilder builder = new StringBuilder();
        builder.append(year).append("-").append(monthOfYear).append("-").append(dayOfMonth).append(" ");
         editText.append(builder.toString());
    }
}

class MyTimePickListener implements TimePickerDialog.OnTimeSetListener
{

    private final MaterialEditText editText;

    public MyTimePickListener(MaterialEditText text)
    {
        this.editText = text;
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        StringBuilder builder = new StringBuilder();
        builder.append(hourOfDay).append(":00:00");
        editText.append(builder.toString());
    }
}
