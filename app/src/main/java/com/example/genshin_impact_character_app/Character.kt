package com.example.genshin_impact_character_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val description: String,
    val photo: String,
    val weapon: String,
    val photoSplash: String,
    val vision: String,
    val primaryAttribute: String,
    val constellation: String,
    val affiliation: String,
    val birthday: String,
    val vaEN: String,
    val vaJP: String,
    val vaCN: String,
    val vaKR: String
) : Parcelable
