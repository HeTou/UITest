package com.example.testlib.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testlib.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(), View.OnClickListener, View.OnLongClickListener {
    lateinit var btn: Button
    lateinit var et: EditText
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_main, container, false)
        return inflate

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn = view.findViewById<Button>(R.id.btn_click)
        et = view.findViewById(R.id.et_text)

        btn_click.setOnClickListener(this)
        tv.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_click -> {
                Toast.makeText(requireContext(), "单击", Toast.LENGTH_LONG).show()
            }
            R.id.tv -> {
                Toast.makeText(requireContext(), "fragment-click", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        when (p0?.id) {
            R.id.btn_click -> {
                tv_text.visibility = if (tv_text.visibility == View.GONE) View.VISIBLE else View.GONE
                Toast.makeText(requireContext(), "长按", Toast.LENGTH_LONG).show()
            }
            R.id.tv -> {
                Toast.makeText(requireContext(), "fragment-long-click", Toast.LENGTH_LONG).show()

            }
        }
        return true
    }
}