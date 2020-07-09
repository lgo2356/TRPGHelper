package com.hun.trpghelper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hun.trpghelper.adapter.DiceAdapter
import com.hun.trpghelper.dialog.DiceAddDialogFragment
import com.hun.trpghelper.dialog.DiceRollPopupFragment
import com.hun.trpghelper.dto.Dice
import kotlinx.android.synthetic.main.activity_dice.*

class DiceActivity : AppCompatActivity() {

    private val dices = ArrayList<Dice>()
    private val diceAdapter = DiceAdapter(dices)
    private val diceAddDialog = DiceAddDialogFragment()
    private val diceRollPopup = DiceRollPopupFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        setSupportActionBar(toolbar_dice)

        recycler_dice_list.adapter = diceAdapter
        recycler_dice_list.layoutManager = LinearLayoutManager(this)

        diceAdapter.setOnItemClickListener(object : DiceAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val diceFigure: Int = diceAdapter.getDiceFigure(position)
                val bundle = Bundle()
                bundle.putInt("figure", diceFigure)
                diceRollPopup.arguments = bundle

                diceRollPopup.show(supportFragmentManager, "missiles")
            }
        })

        diceAddDialog.setOnDiceAddListener(object : DiceAddDialogFragment.OnDiceAddListener {
            override fun onDiceAdd(name: String, figure: Int) {
                diceAdapter.addDice(name, figure)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_dice, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_dice -> {
                diceAddDialog.show(supportFragmentManager, "missiles")
//                diceRollPopup.show(supportFragmentManager, "missiles")
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
