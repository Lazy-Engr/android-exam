package com.example.randomusertest.Presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.randomusertest.Data.PersonService;
import com.example.randomusertest.Domain.CacheManager;
import com.example.randomusertest.Domain.Person;
import com.example.randomusertest.Domain.PersonResponse;
import com.example.randomusertest.Presentation.PersonAdapter;
import com.example.randomusertest.R;
import com.example.randomusertest.Utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerViewPersons;
    private PersonAdapter adapter;
    private List<Person> persons = new ArrayList<>();

    private PersonService personService; // Declare your service interface
    private CacheManager cacheManager; // Cache manager instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        recyclerViewPersons = findViewById(R.id.recyclerViewPersons);
        recyclerViewPersons.setLayoutManager(new LinearLayoutManager(this));
        // Add divider decoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewPersons.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerViewPersons.addItemDecoration(dividerItemDecoration);
        adapter = new PersonAdapter(persons);
        recyclerViewPersons.setAdapter(adapter);

        cacheManager = new CacheManager(this); // Initialize CacheManager

        // Initialize Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create the PersonService interface using Retrofit
        personService = retrofit.create(PersonService.class);

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
        loadData(); // Load data when activity is first created
    }

    private void loadData() {
        // Check network connectivity
        if (NetworkUtils.isNetworkConnected(this)) {
            // If connected, load data from API
            loadPersons();
        } else {
            // If no network, load cached data
            loadCachedPersons();
            Toast.makeText(this, "No internet connection. Showing cached data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void refreshData() {
        // Check network connectivity
        if (NetworkUtils.isNetworkConnected(this)) {
            // If connected, fetch fresh data from API
            loadPersons();
        } else {
            // If no network, show message and stop refreshing
            Toast.makeText(this, "No internet connection. Cannot refresh data.", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
            // Load cached data
            loadCachedPersons();
        }
    }

    private void loadPersons() {
        swipeRefreshLayout.setRefreshing(true);

        personService.getPersons().enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccessful()) {
                    List<Person> newPersons = parsePersonResponse(response.body());
                    showPersons(newPersons);

                    // Save fetched data to cache
                    cacheManager.savePersons(response.body().toString());
                } else {
                    handleApiError();
                }
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                handleApiError();
            }
        });
    }

    private void loadCachedPersons() {
        String cachedData = cacheManager.getPersons();
        if (cachedData != null && !cachedData.isEmpty()) {
            List<Person> cachedPersons = parseJsonToPersons(cachedData);
            showPersons(cachedPersons);

        } else {
            Toast.makeText(this, "No cached data available.", Toast.LENGTH_SHORT).show();

        }
    }

    private void handleApiError() {
        Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "API request successful but response unsuccessful");

        // Show cached data if available
        loadCachedPersons();
    }

    private void showPersons(List<Person> newPersons) {
        persons.clear();
        persons.addAll(newPersons);
        adapter.notifyDataSetChanged();
    }

    // Method to parse PersonResponse to List<Person>
    private List<Person> parsePersonResponse(PersonResponse response) {
        List<Person> persons = new ArrayList<>();
        for (PersonResponse.Result result : response.getResults()) {
            Person person = new Person(
                    result.getName().getFirst(),
                    result.getName().getLast(),
                    result.getBirthday(),
                    calculateAge(result.getBirthday()),
                    result.getEmail(),
                    result.getPhone(),
                    result.getAddress(),
                    result.getContactPerson(),
                    result.getContactPersonNumber()
            );
            persons.add(person);
        }
        return persons;
    }

    // Helper method to calculate age
    private String calculateAge(String dob) {
        // Implement your age calculation logic
        return "30"; // Dummy age for demonstration
    }

    // Method to parse cached JSON data to List<Person> (replace with actual JSON parsing logic)
    private List<Person> parseJsonToPersons(String json) {
        List<Person> persons = new ArrayList<>();
        // Replace with actual parsing logic
        return persons;
    }
}
