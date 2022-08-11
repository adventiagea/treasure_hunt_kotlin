package com.dicoding.picodiploma.treasurehunt_kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation

class LoginFragment : Fragment() {

    private val emailDefault : String = "123"
    private val passDefault : String = "123"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.actionBar?.hide()

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val emailInput = view.findViewById<EditText>(R.id.email_input_login)
        val passInput = view.findViewById<EditText>(R.id.pass_input_login)
        val login = view.findViewById<Button>(R.id.logins_button)

        emailInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                login.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.login_gray))
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                login.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.yellow))


                login()
            }

            override fun afterTextChanged(s: Editable?) {
                login.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.yellow))

                login()
            }

        })

        passInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                login.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.login_gray))
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                login.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.yellow))


                login()
            }

            override fun afterTextChanged(s: Editable?) {
                login.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.yellow))

                login()
            }

        })

        val register = view.findViewById<TextView>(R.id.register_login)

        register?.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.register_login)
        }

        val forgot = view.findViewById<TextView>(R.id.forgot_login)

        forgot.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun login(){
        val emailInput = view?.findViewById<EditText>(R.id.email_input_login)
        val passInput = view?.findViewById<EditText>(R.id.pass_input_login)
        val login = view?.findViewById<Button>(R.id.logins_button)
        login?.setOnClickListener {
            if (emailInput?.text.toString().isNotEmpty() && passInput?.text.toString().isNotEmpty()) {
                if (emailInput?.text.toString() == emailDefault && passInput?.text.toString() == passDefault) {
                    Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_mainActivity)

                } else {
                    Toast.makeText(activity, "Email dan Password salah!", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(activity, "Masukkan Email dan Password!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}