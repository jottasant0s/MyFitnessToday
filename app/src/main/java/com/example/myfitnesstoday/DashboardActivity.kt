package com.example.myfitnesstoday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    private lateinit var rvDashboard: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val adapter = DashboardAdapter()
        rvDashboard = findViewById(R.id.rvDashboard)
        rvDashboard.adapter = adapter
        rvDashboard.layoutManager = LinearLayoutManager(this)
    }

    private inner class DashboardAdapter : RecyclerView.Adapter<DashboardViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
            val view = layoutInflater.inflate(R.layout.dashboard_item, parent, false)
            val viewHolder = DashboardViewHolder(view)
            return viewHolder
        }

        override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        }

        override fun getItemCount(): Int {
            return 2
        }

    }

    private class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}