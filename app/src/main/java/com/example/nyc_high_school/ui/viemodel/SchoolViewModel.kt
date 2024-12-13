package com.example.nyc_high_school.ui.viemodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nyc_high_school.data.model.HighSchool
import com.example.nyc_high_school.data.model.SATScore
import com.example.nyc_high_school.data.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(private val repository: SchoolRepository):ViewModel() {

    private val _schools = MutableStateFlow<List<HighSchool>>(emptyList())
    val schools: StateFlow<List<HighSchool>> = _schools

    private val _satScores = MutableStateFlow<List<SATScore>>(emptyList())
    val satScores: StateFlow<List<SATScore>> = _satScores
    init {
        fetchSchools()
        fetchSatScores()
    }

    private fun fetchSchools() {
        viewModelScope.launch {
            _schools.value = repository.getSchools()
        }

        viewModelScope.launch {
            try {
              //  val schools = repository.getSchools()
                _schools.value = repository.getSchools()

            } catch (e: SocketTimeoutException) {
                Log.e("ViewModel", "Timeout while fetching schools: ${e.message}")
            } catch (e: Exception) {
                Log.e("ViewModel", "Error fetching schools: ${e.message}")

            }
        }
    }

    private fun fetchSatScores() {
        viewModelScope.launch {
            _satScores.value = repository.getSatScores()
        }
    }
}