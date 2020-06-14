package com.example.soptthirdgrowthassignment.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.soptthirdgrowthassignment.R
import com.example.soptthirdgrowthassignment.main.MainActivity
import com.example.soptthirdgrowthassignment.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    val requestToServer : RequestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if(et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
            }else{
                //로그인 요청

                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_password.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Log.d("통신 실패", "안됩니다")
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if(response.isSuccessful){
                            if(response.body()!!.success){
                                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this@LoginActivity, "아이디/비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
//                requestToServer.service.requestLogin(
//                    RequestLogin(
//                        id = et_id.text.toString(),
//                        password = et_password.text.toString()
//                    )//로그인 정보를 전달
//                ).enqueue(object : Callback<ResponseLogin>{
//                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                        //통신 실패
//                        Log.d("통신 실패", "안됩니다")
//                    }
//
//                    override fun onResponse(
//                        call: Call<ResponseLogin>,
//                        response: Response<ResponseLogin>
//                    ) {
//                        //통신 성공
//                        if(response.isSuccessful){ //statusCode가 200~300 사이일 떄
//                            if(response.body()!!.success){ //ResponseLogin의 success가 true인 경우
//                                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
//                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                                startActivity(intent)
//                                finish()
//                            }else{
//                                Toast.makeText(this@LoginActivity, "아이디/비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                    }
//
//                })
            }
        }
        tv_register.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            Log.d("인텐트 만들고", "스타트액티비티 전까지")
            startActivity(intent)
            Log.d("인텐트 작동", "스타트액티비티 전까지")
        }
    }
}
