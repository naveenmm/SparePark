package com.example.sparepark.ui.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.sparepark.R
import com.example.sparepark.SpareParkApplication
import com.example.sparepark.database.SpaceRaw
import com.example.sparepark.ui.adapter.SpaceDetailsAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [SpaceDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpaceDetail(private var spaces: List<SpaceRaw>) : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var spaceDetailsList = view.findViewById(R.id.spaceDetailsList) as ListView
        var spaceDetailsAdapter = SpaceDetailsAdapter(SpareParkApplication.instance, R.layout.space_deatil_tile, spaces)
        spaceDetailsList.adapter = spaceDetailsAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_space_detail, container, false)
    }

}