package com.example.randomusertest.Presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomusertest.Domain.Person;
import com.example.randomusertest.R;

import java.util.List;

/**
 * The type Person adapter.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> persons;

    /**
     * Instantiates a new Person adapter.
     *
     * @param persons the persons
     */
    public PersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.bind(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    /**
     * The type Person view holder.
     */
    static class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewFirstName;
        private TextView textViewLastName;
        private TextView textViewBirthday;
        private TextView textViewAge;
        private TextView textViewEmail;
        private TextView textViewMobile;
        private TextView textViewAdress;
        private TextView textViewContact;
        private TextView textViewContactPerson;

        /**
         * Instantiates a new Person view holder.
         *
         * @param itemView the item view
         */
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewBirthday = itemView.findViewById(R.id.textViewBirthday);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewMobile = itemView.findViewById(R.id.textViewMobile);
            textViewAdress = itemView.findViewById(R.id.textViewAddress);
            textViewContact = itemView.findViewById(R.id.textViewContact);
            textViewContactPerson = itemView.findViewById(R.id.textViewContactPerson);
        }

        /**
         * Bind.
         *
         * @param person the person
         */
        public void bind(Person person) {
            textViewFirstName.setText("First Name: " + person.getFirstName());
            textViewLastName.setText("Last Name: " + person.getLastName());
            textViewAge.setText("Age: " + person.getAge());
            textViewBirthday.setText("Birthday: " + person.getBirthday());
            textViewEmail.setText("Email: " + person.getEmail());
            textViewMobile.setText("Number: " + person.getMobile());
            textViewAdress.setText("Address: " + person.getAddress());
            textViewContact.setText("Contact: " + person.getContactPerson());
            textViewContactPerson.setText("Contact Person Number: " + person.getContactPerson());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { }
            });
        }
    }
}
