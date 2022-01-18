package kg.geektech.kotlinless2.Extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.core.content.ContextCompat


fun Context.copyToClipboard(text: CharSequence){
    val clipboard = ContextCompat.getSystemService(this,ClipboardManager::class.java)
    clipboard?.setPrimaryClip(ClipData.newPlainText("",text))
}