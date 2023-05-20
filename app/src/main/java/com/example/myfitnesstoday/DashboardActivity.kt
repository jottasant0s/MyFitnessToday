package com.example.myfitnesstoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    private lateinit var rvDashboard: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val dashboardItems = mutableListOf<DashboardItem>()
        dashboardItems.add(
            DashboardItem(
                id = 1,
                drawableId = R.drawable.icon_button_imc_dashboard,
                TextStringId = R.string.imc_name_dashboard_item
            )
        )

        val adapter = DashboardAdapter(dashboardItems) { id ->
            when (id) {
                1 -> {
                    val i = Intent(this@DashboardActivity, ImcActivity::class.java)
                    startActivity(i)
                }
            }
        }
        rvDashboard = findViewById(R.id.rvDashboard)
        rvDashboard.adapter = adapter
        rvDashboard.layoutManager = LinearLayoutManager(this)
    }

    private inner class DashboardAdapter(
        private val dashboardItem: List<DashboardItem>,
        private val onItemClickListener: (Int) -> Unit
    ) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
            val view = layoutInflater.inflate(R.layout.dashboard_item, parent, false)
            return DashboardViewHolder(view)
        }

        override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
            val itemCurrent = dashboardItem[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return dashboardItem.size
        }

        private inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: DashboardItem) {
                val icon: ImageView = itemView.findViewById(R.id.icon_item)
                val text: TextView = itemView.findViewById(R.id.text_item)
                val container: LinearLayout = itemView as LinearLayout

                icon.setImageResource(item.drawableId)
                text.setText(item.TextStringId)

                container.setOnClickListener {
                    onItemClickListener.invoke(item.id)
                }
            }
        }
    }
}