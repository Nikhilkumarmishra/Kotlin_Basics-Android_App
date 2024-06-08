package com.example.snapchatsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.snapchatsplashscreen.databinding.ActivityFragmentBinding
import com.example.snapchatsplashscreen.databinding.ActivityMainBinding

class FragmentActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFragment1.setOnClickListener {
            goToFragment(Fragment1())
        }
        binding.buttonFragment2.setOnClickListener {
            goToFragment(Fragment2())
        }
    }
    private fun goToFragment(fragment: Fragment){
        fragmentManager= supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}
