package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        view.findViewById<Button>(R.id.sign_out).setOnClickListener{
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)

        //Navigation.findNavController(view).navigate(R.id.action_accountFragment_to_loginFragment)

        }

        view.findViewById<TextView>(R.id.change_password).setOnClickListener{
            val intent = Intent(requireContext(), ChangePasswordActivity::class.java)
            startActivity(intent)

            //Navigation.findNavController(view).navigate(R.id.action_accountFragment_to_changePasswordFragment)
        }

        view.findViewById<TextView>(R.id.about).setOnClickListener {

        }

        view.findViewById<TextView>(R.id.terms_and_conditions).setOnClickListener {

        }

        // Inflate the layout for this fragment
        return view
    }
}