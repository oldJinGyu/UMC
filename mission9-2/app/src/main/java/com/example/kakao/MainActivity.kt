package com.example.kakao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kakao.databinding.ActivityMainBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            UserApiClient.instance.loginWithKakaoAccount(this) { token, error ->
                if (error != null) {
                    Log.e("kakao", "로그인 실패", error)
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
                else if (token != null) {
                    Log.i("kakao", "로그인 성공 ${token.accessToken}")
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    UserApiClient.instance.me { user, error ->
                        if (error != null) {
                            Log.e("kakao", "사용자 정보 요청 실패", error)
                        }
                        else if (user != null) {
                            Log.i("kakao", "사용자 정보 요청 성공")
                        }
                        if (user != null) {
                            binding.textKakao.text = "카카오 닉네임 : ${user.kakaoAccount?.profile?.nickname.toString()}"
                        }
                    }
                }
            }
        }
        binding.btnLogout.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Log.e("kakao", "로그아웃 실패. SDK에서 토큰 삭제됨", error)
                    Toast.makeText(this, "로그아웃 실패", Toast.LENGTH_SHORT).show()
                }
                else {
                    Log.i("kakao", "로그아웃 성공. SDK에서 토큰 삭제됨")
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                    binding.textKakao.text = "카카오 닉네임 : "
                }
            }
        }
    }
}