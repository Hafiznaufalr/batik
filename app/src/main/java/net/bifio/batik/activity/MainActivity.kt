package net.bifio.batik.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import net.bifio.batik.R
import net.bifio.batik.fragment.ListFragment
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
     private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-SemiBold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = ListFragment.newInstance()
        addFragment(fragment)
        play()

    }




    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_belajar -> {
                val fragment = ListFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_more -> {
//                val fragment = MoreFragment()
//                addFragment(fragment)
                val a = Intent(this, CreditActivity::class.java)
                mediaPlayer.release()
                startActivity(a)
                finish()
            }
        }
        false
    }

    //        .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out) suatu saat pasti butuh
    @SuppressLint("PrivateResource")
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Apakah Anda Ingin Keluar?")
            .setCancelable(false)
            .setPositiveButton("Iya") { _, _ -> this@MainActivity.finish()
                mediaPlayer.release()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }

    private fun play(){
            mediaPlayer = MediaPlayer.create(this, R.raw.end)
            mediaPlayer.start()

    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}