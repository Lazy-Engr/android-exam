package com.example.randomusertest.Data;

import com.example.randomusertest.Domain.PersonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * The interface Person service.
 */
public interface PersonService {
    /**
     * Gets persons.
     *
     * @return the persons
     */
    @GET("api/?results=10") // Adjust endpoint URL as needed
    Call<PersonResponse> getPersons();
}

