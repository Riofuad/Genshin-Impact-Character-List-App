package com.example.genshin_impact_character_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacter: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "Genshin Impact Character"

        rvCharacter = findViewById(R.id.rv_characters)
        rvCharacter.setHasFixedSize(true)

        list.addAll(getListCharacters())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCharacter.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCharacter.layoutManager = GridLayoutManager(this, 2)

            }
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
//                Toast.makeText(this, "About page on progress...", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCharacters(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataWeapon = resources.getStringArray(R.array.data_weapon)
        val dataPhotoSplash = resources.getStringArray(R.array.data_splash_img)
        val dataVision = resources.getStringArray(R.array.data_vision)
        val dataPrimaryAttribute = resources.getStringArray(R.array.data_primary_attribute)
        val dataConstellation = resources.getStringArray(R.array.data_constellation)
        val dataAffiliation = resources.getStringArray(R.array.data_affiliation)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataVaEN = resources.getStringArray(R.array.data_vaEN)
        val dataVaJP = resources.getStringArray(R.array.data_vaJP)
        val dataVaCN = resources.getStringArray(R.array.data_vaCN)
        val dataVaKR = resources.getStringArray(R.array.data_vaKR)
        val listCharacter = ArrayList<Character>()
        for (i in dataName.indices) {
            val character = Character(
                dataName[i],
                dataDescription[i],
                dataPhoto[i],
                dataWeapon[i],
                dataPhotoSplash[i],
                dataVision[i],
                dataPrimaryAttribute[i],
                dataConstellation[i],
                dataAffiliation[i],
                dataBirthday[i],
                dataVaEN[i],
                dataVaJP[i],
                dataVaCN[i],
                dataVaKR[i]
            )
            listCharacter.add(character)
        }

        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list, rvCharacter)
        rvCharacter.adapter = listCharacterAdapter

        listCharacterAdapter.setOnItemClickCallback(object :
            ListCharacterAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Character) {
                showSelectedCharacter(data)
            }
        })
    }

    private fun showSelectedCharacter(character: Character) {
        val characterDetailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        characterDetailIntent.putExtra("extra_name", character.name)
        characterDetailIntent.putExtra("extra_photo", character.photo)
        characterDetailIntent.putExtra("extra_photo_splash", character.photoSplash)
        characterDetailIntent.putExtra("extra_description", character.description)
        characterDetailIntent.putExtra("extra_weapon", character.weapon)
        characterDetailIntent.putExtra("extra_vision", character.vision)
        characterDetailIntent.putExtra("extra_primary_attribute", character.primaryAttribute)
        characterDetailIntent.putExtra("extra_constellation", character.constellation)
        characterDetailIntent.putExtra("extra_affiliation", character.affiliation)
        characterDetailIntent.putExtra("extra_birthday", character.birthday)
        characterDetailIntent.putExtra("extra_va_en", character.vaEN)
        characterDetailIntent.putExtra("extra_va_jp", character.vaJP)
        characterDetailIntent.putExtra("extra_va_cn", character.vaCN)
        characterDetailIntent.putExtra("extra_va_kr", character.vaKR)
        startActivity(characterDetailIntent)
//        TODO("go to detail page")
//        Toast.makeText(this, "Kamu memilih " + character.name, Toast.LENGTH_SHORT).show()
    }
}