package com.example.sparepark.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.sparepark.R
import com.example.sparepark.database.SpaceRaw

class SpaceDetailsAdapter(private var _context: Context,
                          private var resource: Int,
                          private var items: List<SpaceRaw>)
    : ArrayAdapter<SpaceRaw>(_context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(_context)
        var vi = convertView
        vi = layoutInflater.inflate(resource, parent, false)
        var imageView: ImageView = vi.findViewById(R.id.spaceImage)
        var txtRate: TextView = vi.findViewById(R.id.rate)
        var txtStreet: TextView = vi.findViewById(R.id.street)
        var txtCity: TextView = vi.findViewById(R.id.city)
        imageView.setImageResource(R.drawable.ic_baseline_directions_car_24)
        txtRate.setText(getItem(position)?.perHour)
        txtStreet.setText(getItem(position)?.street)
        txtCity.setText(getItem(position)?.city)
        return vi
    }
}