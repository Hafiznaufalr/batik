package net.bifio.batik.fragment

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.fragment_list.*
import net.bifio.batik.R
import net.bifio.batik.batiks.BatikGaruda

class MoreFragment : Fragment() {
lateinit var mediaPlayer: MediaPlayer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_more, container, false)



        return view

    }

    companion object {
        fun newInstance(): MoreFragment {
            val fragment = MoreFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}