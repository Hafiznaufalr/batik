package net.bifio.batik.activity

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.bifio.batik.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class CreditActivity : AppCompatActivity() {
lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-SemiBold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        setContentView(R.layout.activity_credit)
        play()
    }
    private fun play(){
        mediaPlayer = MediaPlayer.create(this, R.raw.end)
        mediaPlayer.start()
    }

    override fun onBackPressed() {
        mediaPlayer.release()
        val a = Intent(this, MainActivity::class.java)
        startActivity(a)
        finish()

    }
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
