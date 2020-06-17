package com.example.soptthirdgrowthassignment.main

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soptthirdgrowthassignment.R
import com.example.soptthirdgrowthassignment.main.RecyclerBook.BookAdapter
import com.example.soptthirdgrowthassignment.main.network.RequestBookToServer
import com.example.soptthirdgrowthassignment.main.network.ResponseBook
import kotlinx.android.synthetic.main.fragment_book.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BookFragment : Fragment() {
    lateinit var bookAdapter: BookAdapter
    val requestBookToServer = RequestBookToServer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_book.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        bookAdapter = BookAdapter(view.context)
        rv_book.adapter = bookAdapter
        et_search.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                if(et_search.text.isNullOrBlank()) {
                    Toast.makeText(v.context, "최소 한 글자 이상 입력하세요", Toast.LENGTH_SHORT).show()
                }else{
                    requestBookToServer.service.requestSearchBook(
                        bookTitle = et_search.text.toString(),
                        auth = getString(R.string.auth)
                    ).enqueue(object : Callback<ResponseBook> {
                        override fun onFailure(call: Call<ResponseBook>, t: Throwable) {
                            Log.d("error", t.toString())
                        }
                        override fun onResponse(
                            call: Call<ResponseBook>,
                            response: Response<ResponseBook>
                        ) {
                            if(response.isSuccessful){
                                bookAdapter.datas.clear()
                                val responseBook = response.body()!!.documents
                                bookAdapter.datas = responseBook
                                bookAdapter.notifyDataSetChanged()
                            }
                        }

                    })
                }
                return@OnKeyListener true
            }
            false
        })


    }
    

}