package com.example.genshin_impact_character_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About me"

        val instagram: ImageView = findViewById(R.id.ic_instagram)
        val linkedin: ImageView = findViewById(R.id.ic_linkedin)
        val github: ImageView = findViewById(R.id.ic_github)

        instagram.setOnClickListener {
            val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/imanmustika_"))
            startActivity(instagramIntent)
        }
        linkedin.setOnClickListener {
            val linkedinIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/iman-mustika-ismail-54b2b9224/"))
            startActivity(linkedinIntent)
        }
        github.setOnClickListener {
            val githubIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Riofuad"))
            startActivity(githubIntent)
        }

    }
}