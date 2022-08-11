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
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation

class ForgotPasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.actionBar?.hide()
        val view = inflater.inflate(R.layout.fragment_forgot_password, container, false)
        val back = view.findViewById<ImageButton>(R.id.back_forgot)
        val emailInput = view.findViewById<EditText>(R.id.email_input_forgot)
        val send = view.findViewById<Button>(R.id.send_button)

        back.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }

        emailInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                send.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.login_gray))
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                send.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.yellow))


                emailInput()
            }

            override fun afterTextChanged(s: Editable?) {
                send.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.yellow))

                emailInput()
            }

        })
        // Inflate the layout for this fragment
        return view
    }

    private fun emailInput(){
        val emailInput = view?.findViewById<EditText>(R.id.email_input_forgot)
        val send = view?.findViewById<Button>(R.id.send_button)
        send?.setOnClickListener {
            if (emailInput?.text.toString().isNotEmpty()) {
                val dialog = DialogsFragment()

                dialog.show(requireActivity().supportFragmentManager, "send")

                 Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_mainActivity)
            }
            else {
                Toast.makeText(activity, "Masukkan Email!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}