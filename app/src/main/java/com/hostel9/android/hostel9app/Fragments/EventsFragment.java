package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.adapter.EventAdapter;
import com.hostel9.android.hostel9app.adapter.MessAdapter;
import com.hostel9.android.hostel9app.database.DatabaseHelper;
import com.hostel9.android.hostel9app.model.Event;
import com.hostel9.android.hostel9app.model.Event;
import com.hostel9.android.hostel9app.rest.ApiClient;
import com.hostel9.android.hostel9app.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsFragment extends Fragment {

    private static final String TAG = "MESS_fragment";
    DatabaseHelper db;
    List<Event> events;

    public EventsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(getActivity());
        events = db.getAllEvents();

        Log.d("Event fragment", "onCreate reached" );

//        if (events.size()==0)
//        {
//
//            ApiInterface apiService =
//                    ApiClient.getClient().create(ApiInterface.class);
//
//            Log.d("Event fragment", "downloading the data1" );
//
//            Call<List<Event>> call = apiService.getEvents(/*API_KEY*/);
//            call.enqueue(new Callback<List<Event>>() {
//                @Override
//                public void onResponse(Call<List<Event>>call, Response<List<Event>> response) {
//                    //  Collection<Event> events =response.body().getResults();
//                    List<Event> api_events = response.body();
//
//                    Log.d("Event fragment", "downloading the data2" );
//
//
//                    int updated=0;
//                    for (int i=0; i<api_events.size(); i++)
//                    {
//                        db.updateEventifFound(api_events.get(i));
//                        updated++;
//                    }
////                    recyclerView.setAdapter(new EventAdapter(events, R.layout.list_events, getApplicationContext()));
//                    events = api_events;
//                    Toast.makeText(getActivity(), "loaded from api", Toast.LENGTH_LONG).show();
//
//
//                    Log.d("Event fragment", "Number of events received: " + events.size());
//                }
//
//
//                @Override
//                public void onFailure(Call<List<Event>>call, Throwable t) {
//                    // Log error here since request failed
//                    Log.e(TAG, t.toString());
//                }
//            });
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new EventAdapter(events, R.layout.list_events, recyclerView ,getActivity()));

        return view;

    }


}
