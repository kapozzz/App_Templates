package com.kapozzz.schedule_managment_platform.screens.main.components

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}