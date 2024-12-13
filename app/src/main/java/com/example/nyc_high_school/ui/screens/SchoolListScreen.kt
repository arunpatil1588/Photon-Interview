package com.example.nyc_high_school.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nyc_high_school.data.model.SATScore
import com.example.nyc_high_school.ui.viemodel.SchoolViewModel



@Composable
fun SchoolListScreen(
    navController: NavController,
    viewModel: SchoolViewModel = hiltViewModel()
) {
    val schools = viewModel.schools.collectAsState().value
    val satScores = viewModel.satScores.collectAsState().value

    LazyColumn {
        items(schools) { school ->
            val satScore: SATScore? = satScores.find { it.dbn == school.dbn }
            Text(
                text = school.name,
                style = TextStyle(fontSize = 18.sp, color = Color.Blue),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(
                            "school_details/${school.name}" +
                                    "/${satScore?.mathScore}" +
                                    "/${satScore?.readingScore}" +
                                    "/${satScore?.writingScore}"
                        )
                    }
            )
        }
    }
}