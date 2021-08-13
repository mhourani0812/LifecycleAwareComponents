package com.hourani.lifecycleawarecomponents.views

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.hourani.lifecycleawarecomponents.databinding.MainViewLayoutBinding
import com.hourani.lifecycleawarecomponents.viewmodels.mainViewModel

class mainViewActivity : AppCompatActivity(), LifecycleOwner {
    private lateinit var binding: MainViewLayoutBinding
    private lateinit var viewModel: mainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(mainViewModel::class.java)
        binding = MainViewLayoutBinding.inflate(layoutInflater)
        Toast.makeText(this,"${viewModel.MainViewTextBox}", Toast.LENGTH_LONG).show()
        setContentView(binding.root)
        var textView : TextView = binding.persistText
        textView.text = viewModel.MainViewTextBox

    }

    override fun onResume() {
        super.onResume()
        var textView:TextView = binding.persistText
        textView.text = viewModel.MainViewTextBox
    }

    override fun onStop() {
        viewModel.MainViewTextBox = binding.persistText.text.toString()
        //Toast.makeText(this,"${viewModel.MainViewTextBox}", Toast.LENGTH_LONG).show()
        super.onStop()
    }
}