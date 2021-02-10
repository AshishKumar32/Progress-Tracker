package com.example.progresstracker.admin

import android.R.attr.fillColor
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.progresstracker.R
import com.example.progresstracker.admin.commitHistory.Commit_history
import com.example.progresstracker.admin.project.Project_admin_activity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_admin_dashboard.*


class admin_dashboard : AppCompatActivity() {
    private lateinit var ivUserAvatar: ImageView
    private var EXPAND_AVATAR_SIZE: Float = 0F
    private var COLLAPSE_IMAGE_SIZE: Float = 0F
    private var horizontalToolbarAvatarMargin: Float = 0F
    private lateinit var toolbar: Toolbar
    private lateinit var appBarLayout: AppBarLayout
    private var cashCollapseState: Pair<Int, Int>? = null
    private lateinit var titleToolbarText: AppCompatTextView
    private lateinit var titleToolbarTextSingle: AppCompatTextView
    private lateinit var invisibleTextViewWorkAround: AppCompatTextView
    private lateinit var background: FrameLayout
    /**/
    private var avatarAnimateStartPointY: Float = 0F
    private var avatarCollapseAnimationChangeWeight: Float = 0F
    private var isCalculated = false
    private var verticalToolbarAvatarMargin =0F






    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)
        tile_projects.setOnClickListener{
            val intent = Intent(this, Project_admin_activity::class.java)
           // val options =ActivityOptions.makeSceneTransitionAnimation(this@admin_dashboard, tile_projects, "project")
           // val options =ActivityOptions.makeCustomAnimation(this,R.anim.slide_in, R.anim.nothing)
            startActivity(intent)
        }
        tile_commit_history.setOnClickListener{
            val intent = Intent(this, Commit_history::class.java)
           // val options = ActivityOptions.makeSceneTransitionAnimation(this@admin_dashboard, tile_commit_history, "commit_history")
          //  val options =ActivityOptions.makeCustomAnimation(this,R.anim.slide_in, R.anim.nothing)
            startActivity(intent)
        }







        EXPAND_AVATAR_SIZE = resources.getDimension(R.dimen.default_expanded_image_size)
        COLLAPSE_IMAGE_SIZE = resources.getDimension(R.dimen.default_collapsed_image_size)
        horizontalToolbarAvatarMargin = resources.getDimension(R.dimen.activity_margin)
        /* collapsingAvatarContainer = findViewById(R.id.stuff_container)*/
        appBarLayout = findViewById(R.id.app_bar_layout)
        toolbar = findViewById(R.id.anim_toolbar)
        ivUserAvatar = findViewById(R.id.imgb_avatar_wrap)
        titleToolbarText = findViewById(R.id.tv_profile_name)
        titleToolbarTextSingle = findViewById(R.id.tv_profile_name_single)
        background = findViewById(R.id.fl_background)
        invisibleTextViewWorkAround = findViewById(R.id.tv_workaround)

        (toolbar.height - COLLAPSE_IMAGE_SIZE) * 2
        /**/
        appBarLayout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, i ->
                if (isCalculated.not()) {
                    avatarAnimateStartPointY =
                        Math.abs((appBarLayout.height - (EXPAND_AVATAR_SIZE + horizontalToolbarAvatarMargin)) / appBarLayout.totalScrollRange)
                    avatarCollapseAnimationChangeWeight = 1 / (1 - avatarAnimateStartPointY)
                    verticalToolbarAvatarMargin = (toolbar.height - COLLAPSE_IMAGE_SIZE) * 2
                    isCalculated = true
                }
                /**/
                updateViews(Math.abs(i / appBarLayout.totalScrollRange.toFloat()))
            })

setLineChartData()


    }
    fun setLineChartData()
    {
        val chart = findViewById<View>(R.id.chart) as LineChart

        chart.setBackgroundColor(Color.WHITE)
        chart.setGridBackgroundColor(fillColor)
        chart.setDrawGridBackground(false)

        chart.setDrawBorders(false)

        // no description text

        // no description text
        chart.description.isEnabled = false

        // if disabled, scaling can be done on x- and y-axis separately

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false)

        val l: Legend = chart.legend
        l.setEnabled(false)

        val xAxis = chart.xAxis
        xAxis.isEnabled = false



        val leftAxis = chart.axisLeft
        leftAxis.isEnabled=false
        leftAxis.axisMaximum = 12f
        leftAxis.axisMinimum = 0f
        leftAxis.setDrawAxisLine(false)
        leftAxis.setDrawZeroLine(false)
        leftAxis.setDrawGridLines(false)
        chart.setBackgroundColor(Color.TRANSPARENT)
        chart.setDrawBorders(false)

        chart.axisRight.isEnabled = false
        chart.axisLeft.setDrawAxisLine(false)
        // add data

        // add data
        setData(5, 5f)
        chart.setAutoScaleMinMaxEnabled(true);
        chart.setTouchEnabled(false)
        chart.setViewPortOffsets(0f, 0f, 0f, 0f)
        chart.invalidate()
    }


    private fun setData(count: Int, range: Float) {
        val values: ArrayList<Entry> = ArrayList()
        values.add(Entry(1f, 6f))
        values.add(Entry(2f, 4f))
        values.add(Entry(3f, 3f))
        values.add(Entry(4f, 4f))
        values.add(Entry(5f, 1f))
        values.add(Entry(6f, 5f))
        values.add(Entry(7f, 7f))
        values.add(Entry(8f, 4f))
//        for (i in 0 until count) {
//            val `val` = (Math.random() * range).toFloat() - 30
//            values.add(Entry(i.toFloat(), `val`, resources.getDrawable(R.drawable.top_drag_indicator)))
//        }
        val set1: LineDataSet
        if (chart.data != null &&
            chart.data.dataSetCount > 0
        ) {
            set1 = chart.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            set1.notifyDataSetChanged()
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            // create a dataset and give it a type
            set1 = LineDataSet(values, "DataSet 1")
            set1.setDrawIcons(false)

            // draw dashed line
            //set1.enableDashedLine(10f, 5f, 0f)

            // black lines and points
            set1.color = Color.WHITE
            set1.setCircleColor(Color.WHITE)

            // line thickness and point size
            set1.lineWidth = 2f
            set1.circleRadius = 4f
            //set1.setDrawCircles(true);
            // draw points as solid circles
            set1.setDrawCircleHole(true)

            // customize legend entry
            set1.formLineWidth = 1f
            //set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            set1.formSize = 15f

            // text size of values
            set1.valueTextSize = 0f

            // draw selection line as dashed
            //set1.enableDashedHighlightLine(10f, 5f, 0f)

            // set the filled area
            set1.setDrawFilled(true)
            set1.fillFormatter =
                IFillFormatter { dataSet, dataProvider -> chart.axisLeft.axisMinimum }

            // set color of filled area
            if (Utils.getSDKInt() >= 18) {
                // drawables only supported on api level 18 and above
                val drawable = ContextCompat.getDrawable(this, R.drawable.faded_bg)
                set1.fillDrawable = drawable
            } else {
                set1.fillColor = Color.TRANSPARENT
            }
            val dataSets: ArrayList<ILineDataSet> = ArrayList()
            dataSets.add(set1) // add the data sets

            // create a data object with the data sets
            val data = LineData(dataSets)

            // set data
            chart.data = data
        }
    }









    private fun updateViews(offset: Float) {
        /* apply levels changes*/
        when (offset) {
            in 0.15F..1F -> {
                titleToolbarText.apply {
                    if (visibility != View.VISIBLE) visibility = View.VISIBLE
                    alpha = (1 - offset) * 0.35F
                }
            }

            in 0F..0.15F -> {
                titleToolbarText.alpha = (1f)
                ivUserAvatar.alpha = 1f
            }
        }

        /** collapse - expand switch*/
        when {
            offset < SWITCH_BOUND -> Pair(TO_EXPANDED, cashCollapseState?.second ?: WAIT_FOR_SWITCH)
            else -> Pair(TO_COLLAPSED, cashCollapseState?.second ?: WAIT_FOR_SWITCH)
        }.apply {
            when {
                cashCollapseState != null && cashCollapseState != this -> {
                    when (first) {
                        TO_EXPANDED -> {
                            /* set avatar on start position (center of parent frame layout)*/
                            ivUserAvatar.translationX = 0F
                            /**/
                            background.setBackgroundColor(
                                ContextCompat.getColor(
                                    this@admin_dashboard,
                                    R.color.colorTransparent
                                )
                            )
                            /* hide top titles on toolbar*/
                            titleToolbarTextSingle.visibility = View.INVISIBLE
                        }
                        TO_COLLAPSED -> background.apply {
                            alpha = 0F
                            setBackgroundColor(
                                ContextCompat.getColor(
                                    this@admin_dashboard,
                                    R.color.colorTransparent
                                )
                            )
                            animate().setDuration(250).alpha(1.0F)

                            /* show titles on toolbar with animation*/
                            titleToolbarTextSingle.apply {
                                visibility = View.VISIBLE
                                alpha = 0F
                                animate().setDuration(500).alpha(1.0f)
                            }
                        }
                    }
                    cashCollapseState = Pair(first, SWITCHED)
                }
                else -> {
                    cashCollapseState = Pair(first, WAIT_FOR_SWITCH)
                }
            }

            /* Collapse avatar img*/
            ivUserAvatar.apply {
                when {
                    offset > avatarAnimateStartPointY -> {
                        val avatarCollapseAnimateOffset = (offset - avatarAnimateStartPointY) * avatarCollapseAnimationChangeWeight
                        val avatarSize = EXPAND_AVATAR_SIZE - (EXPAND_AVATAR_SIZE - COLLAPSE_IMAGE_SIZE) * avatarCollapseAnimateOffset
                        this.layoutParams.also {
                            it.height = Math.round(avatarSize)
                            it.width = Math.round(avatarSize)
                        }
                        invisibleTextViewWorkAround.setTextSize(TypedValue.COMPLEX_UNIT_PX, offset)

                        this.translationX = ((appBarLayout.width - horizontalToolbarAvatarMargin - avatarSize) / 2) * avatarCollapseAnimateOffset
                        this.translationY = ((toolbar.height  - verticalToolbarAvatarMargin - avatarSize ) / 2) * avatarCollapseAnimateOffset
                    }
                    else -> this.layoutParams.also {
                        if (it.height != EXPAND_AVATAR_SIZE.toInt()) {
                            it.height = EXPAND_AVATAR_SIZE.toInt()
                            it.width = EXPAND_AVATAR_SIZE.toInt()
                            this.layoutParams = it
                        }
                        translationX = 0f
                    }
                }
            }
        }
    }

    companion object {
        const val SWITCH_BOUND = 0.8f
        const val TO_EXPANDED = 0
        const val TO_COLLAPSED = 1
        const val WAIT_FOR_SWITCH = 0
        const val SWITCHED = 1
    }
}
