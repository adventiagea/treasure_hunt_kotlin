package com.dicoding.picodiploma.treasurehunt_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation

class RegistrationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        val back = view.findViewById<ImageButton>(R.id.back_register)

        back.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_registrationFragment_to_loginFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

}