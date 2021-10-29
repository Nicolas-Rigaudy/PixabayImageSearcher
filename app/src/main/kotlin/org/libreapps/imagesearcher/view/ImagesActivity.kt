package org.libreapps.imagesearcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import org.libreapps.imagesearcher.R
import org.libreapps.imagesearcher.model.Image
import org.libreapps.imagesearcher.model.PixabayApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        manager = LinearLayoutManager(this)

        val inputText : String = intent.getStringExtra("inputText").toString()
        getImages(inputText)
    }

    private fun getImages(inputText : String){

        val query: String = inputText
        val language: String = "en"
        //val id: String = ""
        val imageType: String = "all"
        val orientation: String = "all"
        //val category: String = ""
        val minWidth: Int = 0
        val minHeight: Int = 0
        //val colors: String = ""
        val editorsChoice: Boolean = false
        val safeSearch: Boolean = false
        val order: String = "popular"
        val page: Int = 1
        val perPage: Int = 20

        PixabayApiClient.pixabayApiService.getImages(query, language, imageType, orientation, minWidth, minHeight, editorsChoice, safeSearch, order, page, perPage).enqueue(object:
            Callback<List<Image>> {
            override fun onResponse(
                call: Call<List<Image>>,
                response: Response<List<Image>>
            ) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply{
                        myAdapter = ImagesAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Image>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}