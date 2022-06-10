# Galaxy-Z-Flip-Chaeyeong

### week1

- 필수과제

1. 로그인 페이지 만들기  (SignInActivity)
2. 회원가입 페이지 만들기  (SignUpActivity)
3. 자기소개 페이지 만들기 (HomeActivity)

https://user-images.githubusercontent.com/62435316/162625295-9a5e0341-dfff-46e4-9bf8-1fedb1758a52.gif

### week2

- 필수과제

1. HomeActivity 하단에 FollowerRecyclerView, RepositoryRecyclerView 만들기  
  
    #
#![2주차GIF](https://user-images.githubusercontent.com/62435316/164386240-31e7fb6c-c328-4eb2-a7fe-732eba526938.gif)

### week3



### week4

- 로그인, 회원가입 서버 통신 구현

1. POSTMAN테스트

- signIn Test
<img width="625" alt="스크린샷 2022-05-13 오후 11 14 07" src="https://user-images.githubusercontent.com/62435316/168303206-ee75ecbd-200a-476b-a779-ee5c00d8baba.png">

- signUp Test
<img width="446" alt="스크린샷 2022-05-13 오후 11 14 22" src="https://user-images.githubusercontent.com/62435316/168303244-101a3674-a5ad-4e54-93b5-7042783ae7a7.png">

2. 회원가입완료 + 로그인완료구현
![week4](https://user-images.githubusercontent.com/62435316/168303635-d540ac32-23c5-4839-9b76-4dac35c50844.gif)


3. retrofit interface와 구현체코드

- retrofit Interface
```kotiln
interface SoptService {
    @POST("/auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>

    @POST("/auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}
```
- 구현체
```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://13.124.62.236"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```

4. Request/Response객체에 대한 코드 

- RequestSignUp
```kotlin
data class RequestSignUp(
    @SerializedName("name")
    val name: String,
    val email: String,
    val password: String
)
```

- ResponseSignUp
```kotlin
data class ResponseSignUp(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: String
    )
}
```
