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


class ListFragment : Fragment() {
    lateinit var card4: CardView
    lateinit var card1: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        card1 = view.findViewById(R.id.batik1)
        card1.setOnClickListener {
            val a = Intent(activity, BatikGaruda::class.java)
            startActivity(a)
        }

        card4 = view.findViewById(R.id.batik4)
        card4.setOnClickListener {
            val a = Intent(activity, BatikGaruda::class.java)
            startActivity(a)
        }



        return view

    }

    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}