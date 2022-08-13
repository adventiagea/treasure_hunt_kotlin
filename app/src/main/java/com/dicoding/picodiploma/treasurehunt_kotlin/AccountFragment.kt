package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import de.hdodenhof.circleimageview.CircleImageView

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
            val intent = Intent(requireContext(), AboutActivity::class.java)
            startActivity(intent)
        }

        view.findViewById<TextView>(R.id.terms_and_conditions).setOnClickListener {
            val intent = Intent(requireContext(), TermsAndConditionsActivity::class.java)
            startActivity(intent)
        }

        val uri = "https://images.unsplash.com/photo-1655874184076-c75fce971b46?ixlib=rb-1.2.1&dl=lance-reis-CsO0RhSdc-I-unsplash.jpg&w=640&q=80&fm=jpg&crop=entropy&cs=tinysrgb"
        view.findViewById<CircleImageView>(R.id.profil_image).setImageURI(Uri.parse(uri))

        // https://images.unsplash.com/photo-1655874184076-c75fce971b46?ixlib=rb-1.2.1&dl=lance-reis-CsO0RhSdc-I-unsplash.jpg&w=640&q=80&fm=jpg&crop=entropy&cs=tinysrgb
        return view
    }
}