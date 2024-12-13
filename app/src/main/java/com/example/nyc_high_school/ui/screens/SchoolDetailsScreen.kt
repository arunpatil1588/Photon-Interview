package com.example.nyc_high_school.ui.screens



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nyc_high_school.ui.viemodel.SchoolViewModel

@Composable
fun SchoolDetailsScreen(name: String, math: String?, reading: String?, writing: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp) // Adds vertical spacing between items
    ){
        Text(text = "School Name: $name", style = TextStyle(fontSize = 20.sp,color = Color.Blue))
        Text(text = "Math Score: ${math ?: "N/A"}", style = TextStyle(fontSize = 16.sp, color = Color.Magenta))
        Text(text = "Reading Score: ${reading ?: "N/A"}",style = TextStyle(fontSize = 16.sp, color = Color.Magenta))
        Text(text = "Writing Score: ${writing ?: "N/A"}",style = TextStyle(fontSize = 16.sp, color = Color.Magenta))
    }


}


