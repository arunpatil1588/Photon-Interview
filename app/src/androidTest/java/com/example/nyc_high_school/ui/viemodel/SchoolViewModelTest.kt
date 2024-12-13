package com.example.nyc_high_school.ui.viemodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nyc_high_school.data.model.HighSchool
import com.example.nyc_high_school.data.model.SATScore
import com.example.nyc_high_school.data.repository.SchoolRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import java.net.SocketTimeoutException

@ExperimentalCoroutinesApi
class SchoolViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val mockRepository = mockk<SchoolRepository>() // Mocked repository

    @Test
    fun test_fetchSchools_updates_schools_state() = runTest {
        // Mocked data
        val mockSchools = listOf(
            HighSchool("School A", "123 Main St", "1111","988989889","abc.com","asa"),
            HighSchool("School B", "456 Elm St", "2222","988989889","abc.com","asa")
        )

        // Mock the repository's respons"
        coEvery { mockRepository.getSchools() } returns mockSchools

        // Create ViewModel with mocked repository
        val viewModel = SchoolViewModel(mockRepository)

        // Wait for the fetchSchools coroutine to complete
        advanceUntilIdle()

        // Assert that the schools state was updated
        val actualSchools = viewModel.schools.first()
        assertEquals(mockSchools, actualSchools)
    }

    @Test
    fun test_fetchSatScores_updates_SAT_scores_state() = runTest {
        // Mocked SAT score data
        val mockSatScores = listOf(
            SATScore("1111", "400", "450", "430","333"),
            SATScore("2222", "410", "460", "440","444")
        )

        // Mock the repository's response
        coEvery { mockRepository.getSatScores() } returns mockSatScores

        // Create ViewModel with mocked repository
        val viewModel = SchoolViewModel(mockRepository)

        // Wait for the fetchSatScores coroutine to complete
        advanceUntilIdle()

        // Assert that the SAT scores state was updated
        val actualSatScores = viewModel.satScores.first()
        assertEquals(mockSatScores, actualSatScores)
    }

    @Test
    fun test_fetchSchools_handles_SocketTimeoutException() = runTest {
        // Mock the repository to throw a SocketTimeoutException
        coEvery { mockRepository.getSchools() } throws SocketTimeoutException("Timeout")

        // Create ViewModel with mocked repository
        val viewModel = SchoolViewModel(mockRepository)

        // Wait for the fetchSchools coroutine to complete
        advanceUntilIdle()

        // Assert that the schools state remains empty
        val actualSchools = viewModel.schools.first()
        assertEquals(emptyList<HighSchool>(), actualSchools)
    }

    @Test
    fun test_fetchSchools_handles_generic_exception() = runTest {
        // Mock the repository to throw a generic exception
        coEvery { mockRepository.getSchools() } throws Exception("Some error")

        // Create ViewModel with mocked repository
        val viewModel = SchoolViewModel(mockRepository)

        // Wait for the fetchSchools coroutine to complete
        advanceUntilIdle()

        // Assert that the schools state remains empty
        val actualSchools = viewModel.schools.first()
        assertEquals(emptyList<HighSchool>(), actualSchools)
    }
}
