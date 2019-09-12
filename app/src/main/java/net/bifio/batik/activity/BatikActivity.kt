package net.bifio.batik.activity

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_batik.*
import net.bifio.batik.R
import net.bifio.batik.adapter.BatikAdapter
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class BatikActivity : AppCompatActivity() {
    lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-SemiBold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        setContentView(R.layout.activity_batik)
        play()

        val list = ArrayList<Int>()
        list.add(R.drawable.owl)
        list.add(R.drawable.slide2)
        list.add(R.drawable.slide3)
        list.add(R.drawable.slide4)
        list.add(R.drawable.slide5)
        intro_vp.adapter = BatikAdapter(list)
        intro_indicator.setViewPager(intro_vp)

        intro_vp.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                when(intro_vp.currentItem){
                    0 ->{
                        intro_tv.visibility = View.VISIBLE
                        intro_tv.text = "Usap Layar"
                        intro_tv.isClickable = false
                    }
                    1 ->{intro_tv.visibility = View.GONE}
                    2 -> {intro_tv.visibility = View.GONE}
                    3 -> {intro_tv.visibility = View.GONE}
                    4 -> {
                        intro_tv.visibility = View.VISIBLE
                        intro_tv.isClickable = true
                        intro_tv.text = "Klik Selanjutnya >>>"
                    }
                }
            }

            override fun onPageSelected(p0: Int) {
            }
        })

        intro_tv.setOnClickListener {
            //            PrefHelper.setPref(this, "intro", "true")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            mediaPlayer.release()
            finish()
        }


    }

    private fun play(){
            mediaPlayer = MediaPlayer.create(this, R.raw.prolog)
            mediaPlayer.start()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


}


