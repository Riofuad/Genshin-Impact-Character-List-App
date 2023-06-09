package com.example.genshin_impact_character_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var photoMain: ImageView
    private lateinit var photoSplash: ImageView
    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var weapon: TextView
    private lateinit var vision: TextView
    private lateinit var primaryAttribute: TextView
    private lateinit var constellation: TextView
    private lateinit var affiliation: TextView
    private lateinit var birthday: TextView
    private lateinit var vaEN: TextView
    private lateinit var vaJP: TextView
    private lateinit var vaCN: TextView
    private lateinit var vaKR: TextView

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_PHOTO_SPLASH = "extra_photo_splash"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_WEAPON = "extra_weapon"
        const val EXTRA_VISION = "extra_vision"
        const val EXTRA_PRIMARY_ATTRIBUTE = "extra_primary_attribute"
        const val EXTRA_AFFILIATION = "extra_affiliation"
        const val EXTRA_CONSTELLATION = "extra_constellation"
        const val EXTRA_BIRTHDAY = "extra_birthday"
        const val EXTRA_VA_EN = "extra_va_en"
        const val EXTRA_VA_JP = "extra_va_jp"
        const val EXTRA_VA_CN = "extra_va_cn"
        const val EXTRA_VA_KR = "extra_va_kr"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = intent.getStringExtra(EXTRA_NAME)

        photoMain = findViewById(R.id.img_character_main)
        photoSplash = findViewById(R.id.img_character_splash)
        name = findViewById(R.id.text_character_name)
        description = findViewById(R.id.text_description)
        weapon = findViewById(R.id.text_weapon)
        vision = findViewById(R.id.text_vision)
        primaryAttribute = findViewById(R.id.text_primary_attribute)
        constellation = findViewById(R.id.text_constellation)
        affiliation = findViewById(R.id.text_affiliation)
        birthday = findViewById(R.id.text_birthday)
        vaEN = findViewById(R.id.text_vaEnglish)
        vaJP = findViewById(R.id.text_vaJapanese)
        vaCN = findViewById(R.id.text_vaChinese)
        vaKR = findViewById(R.id.text_vaKorean)

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_PHOTO))
            .into(photoMain)

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_PHOTO_SPLASH))
            .into(photoSplash)
        name.text = intent.getStringExtra(EXTRA_NAME)
        description.text = intent.getStringExtra(EXTRA_DESCRIPTION)
        weapon.text = intent.getStringExtra(EXTRA_WEAPON)
        vision.text = intent.getStringExtra(EXTRA_VISION)
        primaryAttribute.text = intent.getStringExtra(EXTRA_PRIMARY_ATTRIBUTE)
        constellation.text = intent.getStringExtra(EXTRA_CONSTELLATION)
        affiliation.text = intent.getStringExtra(EXTRA_AFFILIATION)
        birthday.text = intent.getStringExtra(EXTRA_BIRTHDAY)
        vaEN.text = intent.getStringExtra(EXTRA_VA_EN)
        vaJP.text = intent.getStringExtra(EXTRA_VA_JP)
        vaCN.text = intent.getStringExtra(EXTRA_VA_CN)
        vaKR.text = intent.getStringExtra(EXTRA_VA_KR)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey check this App:")
                shareIntent.type = "text/plain"
                startActivity(Intent.createChooser(shareIntent, "Share To:"))
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}