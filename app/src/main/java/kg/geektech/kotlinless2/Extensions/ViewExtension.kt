package kg.geektech.kotlinless2.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(resource:String){

    Glide.with(this)
        .load(resource)
        .centerCrop()
        .into(this)


}