package com.niki.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.niki.weatherapp.R
import com.niki.weatherapp.adapters.WeatherAdapter
import com.niki.weatherapp.adapters.WeatherModel
import com.niki.weatherapp.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("Moscow", "17:40", "Sunny", "25C",
                " ", " ", " ", " "),
            WeatherModel("Moscow", "18:40", "Sunny", "23C",
                " ", " ", " ", " "),
            WeatherModel("Moscow", "19:40", "Sunny", "20C",
                " ", " ", " ", " ")
        )
        adapter.submitList(list)

    }
    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()

    }
}