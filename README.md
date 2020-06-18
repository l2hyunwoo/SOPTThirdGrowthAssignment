# SOPTThirdGrowthAssignment
3주차 필수과제 및 성장과제
+ 로그인 서버 통신
+ Kakao API를 활용한 데이터 통신

## ```Retrofit2```로 데이터 통신하기
### API 내용 확인
다음과 같은 내용들을 확인해야한다.
+ baseUrl
+ 데이터 전달 방식(GET, POST)
+ Header
+ request/response에 필요한 내용(body)

### ```RequestData```, ```ResponseData``` 클래스 구축
송수신을 할 때 필요한 데이터 구조를 data class 형태로 구축한다.
#### data class RequestLogin
```
data class RequestLogin (
    val id: String,
    val password: String
)
```
#### data class ResponseBook, BookXMLData
```
data class ResponseBook (
    val documents : MutableList<BookXMLData>
)

data class BookXMLData(
    val contents : String,
    val title:String,
    val thumbnail:String
)
```

### Request 요청 Interface 설계
#### interface RequestInterface
```
interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>
}
```

### Interface 구현 객체(Object) 만들기
#### object RequestToServer
```
object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("서버주소 baseUrl")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //인터페이스 구현 객체
    var service: RequestInterface = retrofit.create(
        RequestInterface::class.java)
}
```

### Activity, Fragment에서 서버 통신
#### LoginActivity
```
btn_login.setOnClickListener {
            //EditText에 입력된 것이 없는 경우
            if(et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank()){
                //EditText에 입력된 것이 없는 경우
            }else{//입력된 것이 있는 경우
                //requestToserver: 서버 연결 객체
                //service 메서드: 서버 연결 인터페이스 구현 객체
                //interface RequestInterface.requestLogin: body에 request 내용 적고 서버와 통신
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_password.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        //서버 연결 실패 시
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if(response.isSuccessful){//statusCode가 200-300 사이인 경우
                            if(response.body()!!.success){//response의 body에 success가 true인 경우
                                //동작 수행
                            }else{
                                
                            }
                        }
                    }

                })
            }
        }
```
