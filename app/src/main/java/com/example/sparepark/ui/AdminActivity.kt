package com.example.sparepark.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sparepark.R
import com.example.sparepark.database.RoomDB
import com.example.sparepark.database.SpaceRaw
import com.example.sparepark.ui.adapter.ViewPagerAdapter
import com.example.sparepark.ui.fragments.SpaceDetail
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AdminActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var authSpaceList: List<SpaceRaw>
    private lateinit var UnAuthSpaceList: List<SpaceRaw>
    val db = RoomDB.getDatabase()!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL)
        GlobalScope.launch {
            authSpaceList = db.spaceDao().getAuthorized()
            UnAuthSpaceList = db.spaceDao().getUnauthorized()
                withContext(Dispatchers.Main) {
                setUpTabs()
            }
        }
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SpaceDetail(authSpaceList), "APPROVED")
        adapter.addFragment(SpaceDetail(UnAuthSpaceList), "UnApproved")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}