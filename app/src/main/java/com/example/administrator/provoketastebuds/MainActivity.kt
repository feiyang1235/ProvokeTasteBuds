package com.example.administrator.provoketastebuds

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast

import com.example.administrator.provoketastebuds.ui.main.MainFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        txt_tab_discover.isSelected = true
        txt_tab_discover.setOnClickListener {
            txt_tab_discover.isSelected = true
            txt_tab_lesson.isSelected = false
            txt_tab_live.isSelected = false
            when (findNavController(this@MainActivity, R.id.fragment).currentDestination?.id) {
                R.id.navDemoFragment -> return@setOnClickListener
                R.id.nav2DemoFragment -> {
                    findNavController(this@MainActivity, R.id.fragment).popBackStack()
                    findNavController(this@MainActivity, R.id.fragment).navigate(R.id.action_nav2DemoFragment_to_navDemoFragment)
                }
                R.id.blankFragment -> {
                    findNavController(this@MainActivity, R.id.fragment).popBackStack()
                    findNavController(this@MainActivity, R.id.fragment).navigate(R.id.action_blankFragment_to_navDemoFragment)
                }
            }
        }
        txt_tab_lesson.setOnClickListener {
            txt_tab_discover.isSelected = false
            txt_tab_lesson.isSelected = true
            txt_tab_live.isSelected = false
            when (findNavController(this@MainActivity, R.id.fragment).currentDestination?.id) {
                R.id.navDemoFragment -> {
                    findNavController(this@MainActivity, R.id.fragment).popBackStack()
                    findNavController(this@MainActivity, R.id.fragment).navigate(R.id.action_navDemoFragment_to_nav2DemoFragment2)
                }
                R.id.nav2DemoFragment -> return@setOnClickListener
                R.id.blankFragment -> {
                    findNavController(this@MainActivity, R.id.fragment).popBackStack()
                    findNavController(this@MainActivity, R.id.fragment).navigate(R.id.action_blankFragment_to_nav2DemoFragment)
                }
            }
        }
        txt_tab_live.setOnClickListener {
            txt_tab_discover.isSelected = false
            txt_tab_lesson.isSelected = false
            txt_tab_live.isSelected = true
            when (findNavController(this@MainActivity, R.id.fragment).currentDestination?.id) {
                R.id.navDemoFragment -> {
                    findNavController(this@MainActivity, R.id.fragment).popBackStack()
                    findNavController(this@MainActivity, R.id.fragment).navigate(R.id.action_navDemoFragment_to_blankFragment)
                }
                R.id.nav2DemoFragment -> {
                    findNavController(this@MainActivity, R.id.fragment).popBackStack()
                    findNavController(this@MainActivity, R.id.fragment).navigate(R.id.action_nav2DemoFragment_to_blankFragment)
                }
                R.id.blankFragment -> return@setOnClickListener
            }
        }
    }

    private var mBackCount = 0
    override fun onSupportNavigateUp(): Boolean {
        if (mBackCount > 0) {
            super.onBackPressed()
        } else {
            ++mBackCount
            Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show()
        }
        return findNavController(this, R.id.fragment).navigateUp()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        mBackCount = 0
        return super.dispatchTouchEvent(ev)
    }
}
