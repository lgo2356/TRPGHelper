package com.hun.trpghelper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hun.trpghelper.adapter.DiceAdapter
import com.hun.trpghelper.dialog.DiceAddDialogFragment
import com.hun.trpghelper.dto.Dice
import kotlinx.android.synthetic.main.activity_dice.*

class DiceActivity : AppCompatActivity() {

    private val dices = ArrayList<Dice>()
    private val diceAdapter = DiceAdapter(dices)
    private val diceAddDialog = DiceAddDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        setSupportActionBar(toolbar_dice)

        recycler_dice_list.adapter = diceAdapter
        recycler_dice_list.layoutManager = LinearLayoutManager(this)

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
//                diceAdapter.addDice("Dice 01", 4)
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
