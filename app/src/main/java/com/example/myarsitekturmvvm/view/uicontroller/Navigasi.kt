package com.example.myarsitekturmvvm.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myarsitekturmvvm.model.DataJK
import com.example.myarsitekturmvvm.view.FormSiswa
import com.example.myarsitekturmvvm.view.TampilSiswa
import com.example.myarsitekturmvvm.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    //edit 1 : parameter viewModel
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        //edit 2 : Tambahkan variabel uiState
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding( isiRuang)) {
            composable(route = Navigasi.Formulir.name) {
                //edit 3 : Tambahkan variable konteks
                val konteks = LocalContext.current
                FormSiswa(
                    pilihanJK = DataJK.Jenis.map { id ->
                        konteks.getString(id)
                    },
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    //edit 5 : parameter statusUiSiswa
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}


