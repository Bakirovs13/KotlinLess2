package kg.geektech.kotlinless2

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.kotlinless2.Extensions.load
import kg.geektech.kotlinless2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var marvelUrlList = mutableListOf(
        "https://cdn.pixabay.com/photo/2015/03/11/01/33/hulk-667988__340.jpg",
        "https://cdn.pixabay.com/photo/2019/09/03/05/01/spiderman-4448631__480.jpg",
        "https://cdn.pixabay.com/photo/2021/11/12/14/33/captain-america-6789190__480.jpg",
        "https://cdn.pixabay.com/photo/2020/08/07/19/37/iron-man-5471434__480.png",
        "https://cdn.pixabay.com/photo/2021/07/20/14/59/iron-man-6480952__340.jpg"

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()

    }


    private fun initListeners() {

        binding.clipboard.setOnClickListener {
            copyToClipboard("https://t4.ftcdn.net/jpg/04/06/23/13/240_F_406231350_sPZSAkWgSH3yhgVzfuQ2tyNvWAThCKYv.jpg")
            Toast.makeText(this,getString(R.string.toast_copy),Toast.LENGTH_LONG).show()
        }

        binding.submitBtn.setOnClickListener{
            if (binding.urlEt.text.isNotEmpty()){
                val newUrl = binding.urlEt.text.toString()
                marvelUrlList.add(newUrl)
                binding.randomPhotoEv.load(newUrl)
                binding.urlEt.text.clear()
            }
        }

       binding.randomBtn.setOnClickListener {
           val random = Random.nextInt(marvelUrlList.size)
           binding.randomPhotoEv.load(marvelUrlList.get(random))
       }
    }

    private fun Context.copyToClipboard(text: CharSequence){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label",text)
        clipboard.setPrimaryClip(clip)
    }
}