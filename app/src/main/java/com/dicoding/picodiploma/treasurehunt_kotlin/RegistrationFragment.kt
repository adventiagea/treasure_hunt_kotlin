package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.Navigation
import com.dicoding.picodiploma.treasurehunt_kotlin.api.ApiBase
import com.dicoding.picodiploma.treasurehunt_kotlin.data.RegisterUserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val nameInput = view.findViewById<EditText>(R.id.name_input_regis)
        val emailInput = view.findViewById<EditText>(R.id.email_input_regis)
        val passInput = view.findViewById<EditText>(R.id.pass_input_regis)
        val confirmInput = view.findViewById<EditText>(R.id.confirm_pass_input_regis)
        val regisButton = view.findViewById<Button>(R.id.regis_button)

        regisButton.setOnClickListener {
            if (nameInput.text != null ){
                ApiBase.apiInterface.registerUser(emailInput.text.toString(), passInput.text.toString(), nameInput.text.toString(), "", "").enqueue(object :
                    Callback<RegisterUserData>{
                    override fun onResponse(
                        call: Call<RegisterUserData>,
                        response: Response<RegisterUserData>
                    ) {
                        if (response.isSuccessful){
                            startActivity(Intent(requireActivity(), MainActivity::class.java))

                            Toast.makeText(requireContext(), "Menambah user berhasil!", Toast.LENGTH_SHORT).show()

                        }
                    }

                    override fun onFailure(call: Call<RegisterUserData>, t: Throwable) {
                        Toast.makeText(requireContext(), "Menambah user gagal!", Toast.LENGTH_SHORT).show()
                    }
                    })
            }
        }

        // Inflate the layout for this fragment
        return view
    }

}