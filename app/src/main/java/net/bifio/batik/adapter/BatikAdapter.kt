package net.bifio.batik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_intro.view.*
import net.bifio.batik.R

class BatikAdapter(val list: List<Int>) : PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view= LayoutInflater.from(container.context).inflate(R.layout.item_intro, container, false)
        Glide.with(container.context).load(list[position]).into(view.item_intro_iv)


        when(position){
            0 -> {
                view.item_intro_tv_title.text = "Selamat Datang!"
                view.item_intro_tv_desc.setText(R.string.prolog)
            }
            1 -> {
                view.item_intro_tv_title.text = "Awalnya, "
                view.item_intro_tv_desc.setText(R.string.slide2)
            }
            2 -> {
                view.item_intro_tv_title.text = "Batik itu "
                view.item_intro_tv_desc.setText(R.string.slide3)
            }
            3 -> {
                view.item_intro_tv_title.text = "DKKB, "
                view.item_intro_tv_desc.setText(R.string.slide4)
            }
            4 -> {
                view.item_intro_tv_title.text = "Kali ini, "
                view.item_intro_tv_desc.setText(R.string.slide5)
            }

        }

        container.addView(view)
        return view
    }


    override fun isViewFromObject(p0: View, p1: Any): Boolean = p0 == p1

    override fun getCount(): Int = list.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}