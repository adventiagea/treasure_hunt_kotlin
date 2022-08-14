package com.dicoding.picodiploma.treasurehunt_kotlin

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
import com.dicoding.picodiploma.treasurehunt_kotlin.api.RetrofitClient
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.AuthInterface
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.login.LoginBody
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {


    private lateinit var sharedPreferences: SharedPreferences // deklarasi fitur shared preference
    private val preferencesName = "treasureHunt" //key shared preference app
    private val tokenKey = "key_token" //key shared preference token

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.actionBar?.hide()

        sharedPreferences = requireActivity().getSharedPreferences(preferencesName, Context.MODE_PRIVATE) //inisialisasi fitur shared preference

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
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        val forgot = view.findViewById<TextView>(R.id.forgot_login)

        forgot.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun login() {
        val auth = RetrofitClient.init().create(AuthInterface::class.java)
        val emailInput = view?.findViewById<EditText>(R.id.email_input_login)?.text.toString()
        val passInput = view?.findViewById<EditText>(R.id.pass_input_login)?.text.toString()
        val login = view?.findViewById<Button>(R.id.logins_button)

        login?.setOnClickListener {
            if (emailInput.isNotEmpty() && passInput.isNotEmpty()) {

                GlobalScope.launch {
                    val loginFun = auth.login(LoginBody(emailInput, passInput))

                    //if (loginFun.isSuccessful){
                    Log.d("API-login: ", loginFun.message())

                    Log.d("API-login: ", emailInput + passInput)

                        if (loginFun.body()?.isSuccess == true) {

                            saveTokenUser("Bearer "+loginFun.body()?.data?.access_token.toString())

                            val intent = Intent(activity, MainActivity::class.java)

                            startActivity(intent)
                            //Navigation.findNavController(requireView()) .navigate(R.id.action_loginFragment_to_mainActivity)
                        } else {
                            Toast.makeText(activity,"Email dan Password salah!", Toast.LENGTH_SHORT).show()

                            Log.d("API-login: ", loginFun.body()?.errors.toString())
                            //Toast.makeText(activity, "Email dan Password salah!", Toast.LENGTH_SHORT).show()
                        }
                        /*}
                    else {
                        Log.d("API-login: ", loginFun.body().toString())


                        /*
                        val dialogView = View.inflate(context,R.layout.dialog_send_email_yes, null)
                        val builder = AlertDialog.Builder(context)
                        //builder.setView(dialogView)

                        val dialog = builder.create()
                        dialog.show()
                        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


                        val sendEmail = dialogView.findViewById<Button>(R.id.ok_send_email)
                        sendEmail?.setOnClickListener {
                            dialog.dismiss()

                            val intent = Intent(dialogView.context, LoginActivity::class.java)
                            startActivity(intent)
                        }

                         */


                        //Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }

                /*
                if (emailInput?.text.toString() == emailDefault && passInput?.text.toString() == passDefault) {
                    Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_mainActivity)

                } else {
                    Toast.makeText(activity, "Email dan Password salah!", Toast.LENGTH_SHORT).show()
                }

                 */
            }
            else {
                Toast.makeText(activity, "Masukkan Email dan Password!", Toast.LENGTH_SHORT).show()
            }

                     */
                }
            }
        }
    }

    private fun saveTokenUser(token : String) {
        val user: SharedPreferences.Editor = sharedPreferences.edit()

        user.putString(tokenKey, token)
        user.apply()
    }

}